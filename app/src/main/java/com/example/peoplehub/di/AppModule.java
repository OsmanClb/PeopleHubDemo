package com.example.peoplehub.di;


import com.example.peoplehub.data.repo.PersonsDaoRepository;

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
    public PersonsDaoRepository providePersonsDaoRepository(){
        return new PersonsDaoRepository();
    }
}
