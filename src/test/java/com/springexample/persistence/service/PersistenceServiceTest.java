package com.springexample.persistence.service;

import com.springexample.persistence.domain.Address;
import com.springexample.persistence.domain.AddressType;
import com.springexample.persistence.domain.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


/**
 * Created by Ady on 2/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/persistence.xml"})
@Transactional
public class PersistenceServiceTest {

    @Autowired
    private PersonService personService;


    @Ignore
    public void testInjection() {
        Assert.notNull(personService);
    }

    @Test
    @Rollback(value = false)
    public void testService() {
        Person person = new Person();
        person.setFirstName("Aditya");
        person.setLastName("VAshisht");

        Address addressHome = new Address();
        addressHome.setAddressType(AddressType.HOME);
        addressHome.setStreet("Evergreen");
        addressHome.setCity("Ashburn");

        Address addressWork = new Address();
        addressWork.setAddressType(AddressType.OFFICE);
        addressWork.setStreet("Lee Road");
        addressWork.setCity("Chantilly");

        person.addAddress(addressHome);
        person.addAddress(addressWork);



        personService.save(person);
    }


    @Test
    public void getByCity() {
        List<Person> personList = personService.getAllByCity("Ashburn");

        for(Person p: personList) {
            System.out.println(p.getFirstName());
        }


        List<Person> usingAddressTable = personService.getUsingAddressTable("Ashburn");

        Assert.notEmpty(usingAddressTable);
    }

    /*@Test
    @Rollback(value = true)*/
    public void testDelete() {

       personService.delete(1L);

    }






}
