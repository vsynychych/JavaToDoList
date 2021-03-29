package com.example.relation2.Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "toDos")
public class MainList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "list_todo")
    private List<ToDo> toDos = new ArrayList<>();


    public MainList(String title) {
        this.title = title;
    }

    public MainList(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public MainList(String title, List<ToDo> toDos) {
        this.title = title;
        this.toDos = toDos;
    }

}
