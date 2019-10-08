package com.example.SpringbootTutorial.dao;

import com.example.SpringbootTutorial.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getAge()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> personExist = selectPersonById(id);
        if (personExist.isEmpty()){
            return 0;
        }
        DB.remove(personExist.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p -> {
                    int indexPersonToUpdate = DB.indexOf(p);
                    if (indexPersonToUpdate >= 0){
                        DB.set(indexPersonToUpdate, new Person(id, person.getName(), person.getAge()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
