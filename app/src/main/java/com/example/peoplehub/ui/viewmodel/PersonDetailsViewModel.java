package com.example.peoplehub.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.peoplehub.data.repo.PersonsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonDetailsViewModel extends ViewModel {
    private PersonsDaoRepository prepo;

    @Inject
    public PersonDetailsViewModel(PersonsDaoRepository prepo){
        this.prepo = prepo;
    }

    public void update(int personId, String personName, String personTel){
        prepo.personUpdate(personId,personName,personTel);
    }
}
