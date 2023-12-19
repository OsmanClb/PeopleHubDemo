package com.example.peoplehub.data.repo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.peoplehub.data.entity.Person;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonsDaoRepository {
    private MutableLiveData<List<Person>> personsList ;
    private DatabaseReference refPersons;

    public PersonsDaoRepository(DatabaseReference refPersons) {
        this.refPersons = refPersons;
        personsList = new MutableLiveData<>();
    }
    public MutableLiveData<List<Person>> getPersonsList(){
        return personsList;
    }
    public void personSave(String personName, String personTel){
        Person person = new Person("",personName,personTel);
        refPersons.push().setValue(person);
    }
    public void personUpdate(String personId, String personName, String personTel){
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("personName",personName);
        hashMap.put("personTel",personTel);
        refPersons.child(personId).updateChildren(hashMap);
    }
    public void personSearch(String query) {
        refPersons.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Person> list = new ArrayList<>();

                for (DataSnapshot d : snapshot.getChildren()){
                    Person person = d.getValue(Person.class);
                    if (person != null){
                        if (person.getPersonName().toLowerCase().contains(query.toLowerCase())){
                            person.setPersonId(d.getKey());
                            list.add(person);
                        }
                    }
                }
                personsList.setValue(list);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void personDelete(String personId){
        refPersons.child(personId).removeValue();
    }
    public void allPersons(){
       refPersons.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               ArrayList<Person> list = new ArrayList<>();

               for (DataSnapshot d : snapshot.getChildren()){
                   Person person = d.getValue(Person.class);
                   if (person != null){
                       person.setPersonId(d.getKey());
                       list.add(person);
                   }
               }
               personsList.setValue(list);
           }
           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
    }

}
