package com.springexample.persistence.service;

import com.springexample.persistence.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ady on 2/3/17.
 */
@Component // Spring component
@Transactional // Annotation driven transaction
public class PersonService {


    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {

        // From the factory get a "current" session

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(person);

    }


}
