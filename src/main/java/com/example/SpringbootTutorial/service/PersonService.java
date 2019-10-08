package com.example.SpringbootTutorial.service;

import com.example.SpringbootTutorial.dao.PersonDao;
import com.example.SpringbootTutorial.model.Person;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
}
