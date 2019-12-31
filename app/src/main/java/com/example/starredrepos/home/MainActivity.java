package com.example.starredrepos.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.starredrepos.R;
import com.example.starredrepos.models.Repos;
import com.example.starredrepos.models.requests.PaginationRQ;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements homeView {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    homePresenter presenter;

    private List<Repos> reposList = new ArrayList<>();

    private StarredReposAdapter starredReposAdapter;

    private PaginationRQ paginationRQ = new PaginationRQ();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StarredReposApp.getInstance().setCurrentActivity(this);
        ButterKnife.bind(this);
        StarredReposApp.getInstance().getAppComponent().inject(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        starredReposAdapter = new StarredReposAdapter(this, reposList);
        recyclerView.setAdapter(starredReposAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
           /*@Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }*/

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0){
                    presenter.getStarredRepos(paginationRQ);
                }
            }
        });
        presenter.bind(this);
        presenter.getStarredRepos(paginationRQ);

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getStarredReposList(List<Repos> starredReposList) {
        reposList.addAll(starredReposList);
        starredReposAdapter.setStarredReposList(reposList);
        paginationRQ.setPage(paginationRQ.getPage()+1);
    }

    @Override
    public void showError() {

    }
}
