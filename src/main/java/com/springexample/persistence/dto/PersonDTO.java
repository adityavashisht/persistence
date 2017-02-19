package com.springexample.persistence.dto;

/**
 * Created by Ady on 2/19/17.
 */
public class PersonDTO {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
