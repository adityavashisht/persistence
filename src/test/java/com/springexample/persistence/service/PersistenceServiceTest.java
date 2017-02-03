package com.springexample.persistence.service;

import com.springexample.persistence.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Ady on 2/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/persistence.xml"})
@Transactional
public class PersistenceServiceTest {

    @Autowired
    private PersonService personService;


    @Test
    @Rollback(value = false)
    public void testService() {
        Person person = new Person();
        person.setFirstName("Aditya");
        person.setLastName("VAshisht");

        personService.save(person);
    }


}
