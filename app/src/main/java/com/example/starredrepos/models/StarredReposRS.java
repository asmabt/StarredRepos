package com.example.starredrepos.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarredReposRS{


	@Expose
	@SerializedName("items")
	private List<Repos> repos;


	public void setItems(List<Repos> repos){
		this.repos = repos;
	}

	public List<Repos> getItems(){
		return repos;
	}

	@Override
 	public String toString(){
		return 
			"StarredReposRS{" + '\'' +
			",items = '" + repos + '\'' +
			"}";
		}
}