package com.example.starredrepos.di;


import com.example.starredrepos.home.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})


public interface AppComponent {

    void inject(MainActivity activity);
}
