package com.example.peoplehub.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.peoplehub.data.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsDaoRepository {
    private MutableLiveData<List<Person>> personsList ;

    public PersonsDaoRepository() {
        personsList = new MutableLiveData<>();
    }
    public MutableLiveData<List<Person>> getPersonsList(){
        return personsList;
    }
    public void personSave(String personName, String personTel){
        Log.e("Person Register",personName + " " + personTel);
    }
    public void personUpdate(int personId, String personName, String personTel){
        Log.e("update", personId + " " + personName + " " + personTel);
    }
    public void personSearch(String query) {
        Log.e("msj",query);
    }
    public void personDelete(int personId){
        Log.e("Kisi Sil", String.valueOf(personId));
    }
    public void allPersons(){
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person(1,"Osman","05330320202"));
        list.add(new Person(2,"Ali","05330329872"));
        list.add(new Person(3,"Veli","05330852202"));

        personsList.setValue(list);
    }

}
