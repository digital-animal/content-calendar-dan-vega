package com.zahid.person.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zahid.person.model.Person;
import com.zahid.person.repository.PersonRepository;

@Service
public class PersonServiceImplementation implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllEntities() {
        // return personRepository.findAll();
        return personRepository.findAllEntities();
    }
    
    @Override
    public List<Person> getEntitiesByName(String name) {
        return personRepository.findAllByName(name);
    }
    
    @Override
    public Person getEntityById(UUID id) {
        return personRepository.findById(id).get();
    }
    
    @Override
    public Person createEntity(Person person) {
        return personRepository.save(person);
    }
    
    @Override
    public Person updateEntity(UUID id, Person entity) {
        Person person = getEntityById(id);
        person.setName(entity.getName());
        person.setEmail(entity.getEmail());
        person.setAddress(entity.getAddress());
        person.setGender(entity.getGender());
        person.setProfession(entity.getProfession());
        person.setUpdatedAt(Instant.now());

        return personRepository.save(person);
    }
    
    @Override
    public Boolean deleteEntityById(UUID id) {
        try {
            personRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @Override
    public Boolean deleteAllEntities() {
        try {
            personRepository.deleteAll();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
