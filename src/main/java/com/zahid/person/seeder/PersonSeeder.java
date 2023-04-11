package com.zahid.person.seeder;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.zahid.person.model.GenderType;
import com.zahid.person.model.Person;
import com.zahid.person.repository.PersonRepository;
import com.zahid.person.service.PersonService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PersonSeeder implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        loadData();
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private void loadData() {

        Faker faker = new Faker();
        List<Person> personList = personService.getAllEntities();
        
        if(personList.size() == 0) {
            GenderType[] genderList = GenderType.values();

            for (int i = 0; i < 100; i++) {
                String name = faker.name().fullName(); // Miss Samanta Schmidt
                String email = faker.internet().emailAddress();
                String address = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
                GenderType gender = genderList[new Random().nextInt(genderList.length)];
                String profession = faker.job().title();
                
                // Person person = Person.builder().name(name).email(email).address(address).profession(profession).build();
                Person person = new Person(name, email, address, gender, profession);
                personList.add(person);
            }
            personRepository.saveAll(personList);
        }
        log.info("Total Person(s): {}", personList.size());
    }
}
