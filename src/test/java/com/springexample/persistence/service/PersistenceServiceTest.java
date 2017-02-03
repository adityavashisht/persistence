package com.springexample.persistence.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;


/**
 * Created by Ady on 2/3/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/persistence.xml"})
public class PersistenceServiceTest {

    @Autowired
    private PersonService personService;


    @Test
    public void testService() {
        Assert.notNull(personService);
    }


}
