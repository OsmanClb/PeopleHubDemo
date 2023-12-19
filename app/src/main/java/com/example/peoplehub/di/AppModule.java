package com.example.peoplehub.di;


import com.example.peoplehub.data.repo.PersonsDaoRepository;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public PersonsDaoRepository providePersonsDaoRepository(DatabaseReference refPersons){

        return new PersonsDaoRepository(refPersons);
    }
    @Provides
    @Singleton
    public DatabaseReference provideDatabaseReference(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        return db.getReference("person");
    }
}
