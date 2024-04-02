package com.pontec.AppRestToDo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "taskcrud")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String description;
}
