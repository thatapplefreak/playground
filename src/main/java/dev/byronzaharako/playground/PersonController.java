package dev.byronzaharako.playground;

import java.util.List;
import java.util.UUID;

import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;

@RestController
public class PersonController {
    
    @Autowired
    private PersonRepository personRepository;

    private Faker faker = new Faker();

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        return ResponseEntity.ok().body(personRepository.findAll());
    }

    @GetMapping("/new")
    public ResponseEntity<Person> addNewPerson() {
        val person = new Person(UUID.randomUUID(), faker.name().fullName());
        personRepository.save(person);
        return ResponseEntity.ok().body(person);
    }

}
