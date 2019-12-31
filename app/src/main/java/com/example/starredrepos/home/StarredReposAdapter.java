package com.example.starredrepos.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starredrepos.R;
import com.example.starredrepos.models.Repos;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StarredReposAdapter extends RecyclerView.Adapter<StarredReposAdapter.ViewHolder> {

    Context context ;
    List<Repos> repos;

    public StarredReposAdapter(Context context, List<Repos> repos) {
        this.context = context;
        this.repos = repos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.repo_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StarredReposAdapter.ViewHolder holder, int position) {
        holder.repoName.setText(repos.get(position).getName());
        holder.repoDescription.setText(repos.get(position).getDescription());
        holder.ownerUserName.setText(repos.get(position).getOwner().getLogin());
        Picasso.with(context).load(repos.get(position).getOwner().getAvatarUrl()).into(holder.ownerAvatar);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        holder.repoScore.setText(numberFormat.format(repos.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    void setStarredReposList(List<Repos> reposList){
        this.repos = reposList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.repo_name)
        TextView repoName;

        @BindView(R.id.owner_username)
        TextView ownerUserName;

        @BindView(R.id.repo_description)
        TextView repoDescription;

        @BindView(R.id.owner_avatar)
        ImageView ownerAvatar;

        @BindView(R.id.repo_score)
        TextView repoScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
