package com.example.starredrepos.home;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.example.starredrepos.BuildConfig;
import com.example.starredrepos.common.network.ApiManager;
import com.example.starredrepos.di.AppComponent;
import com.example.starredrepos.di.AppModule;
import com.example.starredrepos.di.DaggerAppComponent;

public class StarredReposApp extends Application {

    private static StarredReposApp starredReposApp;
    private AppComponent appComponent;
    private AppCompatActivity currentActivity;
    private AppCompatActivity previousActivity;



    public static StarredReposApp getInstance(){
        if(starredReposApp == null)
            starredReposApp = new StarredReposApp();

        return starredReposApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        starredReposApp = this;

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this)) //this : application
                .build();

        ApiManager.getInstance().setupRetrofitAPI(BuildConfig.BASE_URL);

    }


    public AppComponent getAppComponent(){
        return appComponent;
    }
    public void setCurrentActivity(AppCompatActivity currentActivity) {
        if (this.currentActivity != null) {
            this.previousActivity = this.currentActivity;
        }
        this.currentActivity = currentActivity;


    }
}
