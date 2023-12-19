package com.example.peoplehub.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.peoplehub.data.entity.Person;
import com.example.peoplehub.data.repo.PersonsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonRegisterViewModel extends ViewModel {
    private PersonsDaoRepository prepo ;

    @Inject
    public PersonRegisterViewModel(PersonsDaoRepository prepo){
        this.prepo = prepo;
    }
    public void save(String personName, String personTel){
        prepo.personSave(personName,personTel);
    }
}
