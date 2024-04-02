package com.pontec.AppRestToDo.Repository;

import com.pontec.AppRestToDo.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Task, Long> {
}
