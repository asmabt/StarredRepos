package com.example.starredrepos.common.network;

import com.example.starredrepos.Utils.Constants;
import com.example.starredrepos.models.StarredReposRS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constants.STARRED_REPOS_URL)
    Call<StarredReposRS> getStarredReposRS();
}
