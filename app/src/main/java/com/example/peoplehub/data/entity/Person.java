package com.example.peoplehub.data.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String personId;
    private String personName;
    private String personTel;

    public Person() {
    }

    public Person(String personId, String personName, String personTel) {
        this.personId = personId;
        this.personName = personName;
        this.personTel = personTel;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonTel() {
        return personTel;
    }

    public void setPersonTel(String personTel) {
        this.personTel = personTel;
    }
}
