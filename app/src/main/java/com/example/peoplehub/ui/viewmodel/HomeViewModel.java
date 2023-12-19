package com.example.peoplehub.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.peoplehub.data.entity.Person;
import com.example.peoplehub.data.repo.PersonsDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {
    private PersonsDaoRepository prepo;
    public MutableLiveData<List<Person>> personsList = new MutableLiveData<>();
    @Inject
    public HomeViewModel(PersonsDaoRepository prepo){
        this.prepo = prepo;
        personsLoad();
        personsList = prepo.getPersonsList();

    }
    public void search(String query) {
        prepo.personSearch(query);
    }
    public void delete(int personId){
        prepo.personDelete(personId);
    }
    public void personsLoad(){
        prepo.allPersons();
    }
}
