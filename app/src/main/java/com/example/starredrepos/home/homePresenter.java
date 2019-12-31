package com.example.starredrepos.home;

import com.example.starredrepos.appBase.appBasePresenter;
import com.example.starredrepos.common.network.ApiManager;
import com.example.starredrepos.models.Repos;
import com.example.starredrepos.models.StarredReposRS;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homePresenter extends appBasePresenter<homeView> {

    List<Repos> reposList = new ArrayList<>();

    public homePresenter() {
    }


    void getStarredRepos(){
        ApiManager.getInstance().getStarredReposRS().enqueue(new Callback<StarredReposRS>() {
            @Override
            public void onResponse(Call<StarredReposRS> call, Response<StarredReposRS> response) {

                if (response.isSuccessful() && response.body() != null) {
                    StarredReposRS results = response.body();
                    if(results != null && results.getItems().size()>0) {
                        for (Repos item : results.getItems()){
                            reposList.add(item);
                        }
                        view.getStarredReposList(reposList);
                    }
                    else if(view!=null){
                        view.showError();
                    }
                    }
                }

            @Override
            public void onFailure(Call<StarredReposRS> call, Throwable t) {

                if (!call.isCanceled()) {
                    if (view != null) {
                        view.showError();
                    }
                }
            }
        });

    }

}
