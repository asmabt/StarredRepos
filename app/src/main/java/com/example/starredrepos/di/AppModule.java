package com.example.starredrepos.di;

import android.content.Context;

import com.example.starredrepos.home.homePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context){ this.context = context ; }

    @Provides
    @Singleton
    Context providesAppContext(){ return this.context; }

    @Provides
    @Singleton
    homePresenter providesHomePresenter(){return  new homePresenter(); }
}
