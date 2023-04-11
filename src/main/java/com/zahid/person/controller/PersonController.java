package com.zahid.person.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zahid.person.converter.PersonConverter;
import com.zahid.person.dto.PersonDto;
import com.zahid.person.model.Person;
import com.zahid.person.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/person")  
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public List<Person> getAllEntities() {
        return personService.getAllEntities();
    }

    @GetMapping("/search/{name}")
    public List<Person> getEntitiesByName(@PathVariable String name) {
        log.info("name: " + name);  
        return personService.getEntitiesByName(name);
    }

    @GetMapping("/{id}")
    public Person getAllEntityById(@PathVariable("id") UUID id) {
        return personService.getEntityById(id);
    }

    @PostMapping("/add/dto")
    public Person createEntity(@RequestBody PersonDto dto) {
        Person entity = PersonConverter.dtoToEntity(dto);
        return personService.createEntity(entity);
    }

    @PutMapping("/update/{id}")
    public Person updateEntity(@PathVariable("id") UUID id, @RequestBody PersonDto dto) {
        Person entity = PersonConverter.dtoToEntity(dto);
        return personService.updateEntity(id, entity);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteEntityById(@PathVariable("id") UUID id) {
        return personService.deleteEntityById(id);
    }

    @DeleteMapping("/delete/all")
    public Boolean deleteAllEntities() {
        return personService.deleteAllEntities();
    }
}
