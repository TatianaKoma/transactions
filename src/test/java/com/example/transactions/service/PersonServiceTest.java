package com.example.transactions.service;

import com.example.transactions.repesitory.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureTestDatabase
class PersonServiceTest {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @BeforeEach
    void beforeEach() {
        personRepository.deleteAll();
    }

    @Test
    void shouldRollbackTransactionIfNameIsNull() {
        assertThrows(Exception.class, () -> personService.addPeople(null));
        assertEquals(0, personRepository.count());
    }
}
