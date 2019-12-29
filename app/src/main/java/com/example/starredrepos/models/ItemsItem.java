package com.example.starredrepos.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsItem{



	@Expose
	@SerializedName("score")
	private double score;

	@Expose
	@SerializedName("id")
	private int id;

	@Expose
	@SerializedName("full_name")
	private String fullName;

	@Expose
	@SerializedName("name")
	private String name;

	@Expose
	@SerializedName("description")
	private String description;



	@Expose
	@SerializedName("owner")
	private Owner owner;

	@Expose
	@SerializedName("url")
	private String url;



	public void setScore(double score){
		this.score = score;
	}

	public double getScore(){
		return score;
	}


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}





	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}



	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}


	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}





	@Override
 	public String toString(){
		return 
			"ItemsItem{" +
			",score = '" + score + '\'' +
			",id = '" + id + '\'' +
			",full_name = '" + fullName + '\'' +
			",name = '" + name + '\'' +
			",description = '" + description + '\'' +
			",owner = '" + owner + '\'' +
			",url = '" + url + '\'' + 

			"}";
		}
}