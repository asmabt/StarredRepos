package com.example.starredrepos.common.network;

import com.example.starredrepos.BuildConfig;
import com.example.starredrepos.home.StarredReposApp;
import com.example.starredrepos.models.StarredReposRS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.readystatesoftware.chuck.ChuckInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiManager instance;
    private Gson gson;
    private ApiInterface apiInterface ;
    private OkHttpClient client;



    private ApiManager(){
    }

    public static  ApiManager getInstance(){
        if(instance == null) {
            instance = new ApiManager();
        }
        return instance ;
    }

    /**
     * Create Retrofit API
     */
    public void setupRetrofitAPI(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
        instance.apiInterface = retrofit.create(ApiInterface.class);
    }


    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation() // Non annotated with #expose will be excluded
                    .disableHtmlEscaping()
                    .setLenient()
                    .setDateFormat("dd-MMM-yyy")
                    .create();
        }

        return gson;
    }

    public Call<StarredReposRS> getStarredReposRS(){
        return this.apiInterface.getStarredReposRS();
    }

}
