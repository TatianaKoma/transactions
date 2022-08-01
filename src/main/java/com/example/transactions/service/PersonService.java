package com.example.transactions.service;

import com.example.transactions.model.Person;
import com.example.transactions.repesitory.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void addPeople(String name) throws Exception {
        personRepository.saveAndFlush(new Person("Jack", "Brown"));
        personRepository.saveAndFlush(new Person("Julia", "Green"));
        if (name == null) {
            throw new Exception("name cannot be null");
        }
        personRepository.saveAndFlush(new Person(name, "Purple"));
    }
}
