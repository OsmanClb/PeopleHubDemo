package com.example.peoplehub.data.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private int personId;
    private String personName;
    private String personTel;

    public Person(int personId, String personName, String personTel) {
        this.personId = personId;
        this.personName = personName;
        this.personTel = personTel;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
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
