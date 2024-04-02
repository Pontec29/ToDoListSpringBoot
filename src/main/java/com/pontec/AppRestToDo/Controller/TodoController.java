package com.pontec.AppRestToDo.Controller;

import com.pontec.AppRestToDo.Model.Task;
import com.pontec.AppRestToDo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo(){
        return "Hola Mundo....!!!";
    }

    //Consultar
    @GetMapping(value = "/tasks")
    public List <Task> getTasks(){
        return todoRepository.findAll();
    }

    //Guardar
    @PostMapping(value = "/save-task")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "Saved task";
    }

    //Eliminar
    @DeleteMapping(value = "/delete-task/{id}")
    public String deleteTask(@PathVariable Long id){
        Task deleteTask = todoRepository.findById(id).get();
        todoRepository.delete(deleteTask);
        return "Delete Task Ok";
    }


    //Actualizar
    @PutMapping(value = "/update-task/{id}")
    public String updateTask( @PathVariable Long id, @RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save(updateTask);
        return "Update Task";
    }
}
