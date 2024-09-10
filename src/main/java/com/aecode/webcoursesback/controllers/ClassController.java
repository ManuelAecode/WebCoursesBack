package com.aecode.webcoursesback.controllers;

import com.aecode.webcoursesback.dtos.ClassDTO;
import com.aecode.webcoursesback.entities.Class;
import com.aecode.webcoursesback.services.IClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private IClassService cS;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody ClassDTO dto) {
        ModelMapper m = new ModelMapper();
        Class c = m.map(dto, Class.class);
        cS.insert(c);
        return ResponseEntity.status(201).body("" +
                "created successfully");
    }

    @GetMapping
    public List<ClassDTO> list() {
        ModelMapper m = new ModelMapper();
        List<Class> c = cS.list();
        return c.stream()
                .map(classes -> m.map(classes, ClassDTO.class))
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){cS.delete(id);}

    @GetMapping("/{id}")
    public ClassDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ClassDTO dto=m.map(cS.listId(id),ClassDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ClassDTO dto) {
        ModelMapper m = new ModelMapper();
        Class c = m.map(dto, Class.class);
        cS.insert(c);
    }


}
