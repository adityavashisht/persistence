package com.springexample.web.controller;

import com.springexample.persistence.domain.Person;

/**
 * Created by Ady on 2/18/17.
 */
public class PersonForm {

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
