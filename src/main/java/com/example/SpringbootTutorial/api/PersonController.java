package com.example.SpringbootTutorial.api;

import com.example.SpringbootTutorial.model.Person;
import com.example.SpringbootTutorial.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
