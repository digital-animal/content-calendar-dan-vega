package com.zahid.person.service;

import java.util.List;
import java.util.UUID;

import com.zahid.person.model.Person;

public interface PersonService {

    public List<Person> getAllEntities();

    public List<Person> getEntitiesByName(String name);

    public Person getEntityById(UUID id);
    
    public Person createEntity(Person person);

    public Person updateEntity(UUID id, Person entity);

    public Boolean deleteEntityById(UUID id);

    public Boolean deleteAllEntities();

}
