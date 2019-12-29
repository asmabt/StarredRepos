package com.example.starredrepos.common;

import com.example.starredrepos.common.network.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiManager instance;
    private Gson gson;
    private ApiInterface apiInterface ;


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


}
