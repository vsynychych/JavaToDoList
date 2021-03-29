package com.example.relation2.Controllers;

import com.example.relation2.Dao.MainDao;
import com.example.relation2.Models.ToDo;
import com.example.relation2.Models.MainList;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/list")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MainController {

    private final MainDao dao;

    @GetMapping()
    private List<MainList> findAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public MainList getListById(@PathVariable int id) {
        return dao.getOne(id);
    }

//    @PostMapping("/save")
//    public MainList save(@RequestBody MainList mainList) {
//        return dao.save(mainList);
//    }

    @PostMapping("/save")
    private void saves(@RequestParam String title,
                       @RequestParam String titleToDo,
                       @RequestParam String body,
                       @RequestParam String finalData) {
        MainList mainList = new MainList();
        mainList.setTitle(title);
        List<ToDo> skillsList = new ArrayList<>();
        skillsList.add(new ToDo(titleToDo, body, finalData));
        mainList.setToDos(skillsList);
        dao.save(mainList);
    }

    @PostMapping("/savelist")
    public void saveList(@RequestParam String title) {
        MainList mainList = new MainList();
        mainList.setTitle(title);
        dao.save(mainList);
    }

    @PostMapping("/update/{id}")
    private void saves(@PathVariable int id,
                       @RequestParam String title,
                       @RequestParam String titleToDo,
                       @RequestParam String body,
                       @RequestParam String finalData) {
        MainList updateMainList = dao.getOne(id);
        updateMainList.setTitle(title);
        List<ToDo> toDoList = new ArrayList<>();
        toDoList.add(new ToDo(titleToDo, body, finalData));
        updateMainList.setToDos(toDoList);
        dao.save(updateMainList);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        MainList mainList = dao.getOne(id);
        dao.delete(mainList);
        return "Видалено";
    }

}
