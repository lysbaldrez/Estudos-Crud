package com.crud.h2.controller;

import com.crud.h2.model.People;
import com.crud.h2.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PeopleController {

    @Autowired
    private IPeopleService service;

    @RequestMapping("/list")
    public String list (Model model) {
        model.addAttribute("people",service.list());
        return "index";
    }

    @GetMapping("/new")
    public String newPeople() {
        return "add";
    }

    @PostMapping("/add")
    public People add(@Valid People p) throws Exception {
        return service.add(p);
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable int id, Model model){
        People people = service.listPeopleId(id);
        model.addAttribute("people", people);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Valid People p){
        service.edit(p);
        return "redirect:/list";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:/list";
    }
}
