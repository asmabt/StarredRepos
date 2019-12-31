package com.example.starredrepos.home;

import com.example.starredrepos.appBase.appBaseView;
import com.example.starredrepos.models.Repos;
import com.example.starredrepos.models.StarredReposRS;

import java.util.List;

public interface homeView extends appBaseView {

    void getStarredReposList(List<Repos> starredReposList);
    void showError();
}
