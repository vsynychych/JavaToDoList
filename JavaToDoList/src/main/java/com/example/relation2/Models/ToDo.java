package com.example.relation2.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "mainList")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String body;
    private String finalData;

    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "list_todo")
    private MainList mainList;

    public ToDo(String title, String body, String finalData) {
        this.title = title;
        this.body = body;
        this.finalData = finalData;
    }

    public ToDo(MainList mainList) {
        this.mainList = mainList;
    }

    public ToDo(String title, String body, String finalData, MainList mainList) {
        this.title = title;
        this.body = body;
        this.finalData = finalData;
        this.mainList = mainList;
    }
}
