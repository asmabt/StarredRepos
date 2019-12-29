package com.example.starredrepos.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner{


	@Expose
	@SerializedName("repos_url")
	private String reposUrl;

	@Expose
	@SerializedName("starred_url")
	private String starredUrl;

	@Expose
	@SerializedName("login")
	private String login;


	@Expose
	@SerializedName("url")
	private String url;


	@Expose
	@SerializedName("avatar_url")
	private String avatarUrl;

	@Expose
	@SerializedName("id")
	private int id;

	@Expose
	@SerializedName("gravatar_id")
	private String gravatarId;




	public void setReposUrl(String reposUrl){
		this.reposUrl = reposUrl;
	}

	public String getReposUrl(){
		return reposUrl;
	}


	public void setStarredUrl(String starredUrl){
		this.starredUrl = starredUrl;
	}

	public String getStarredUrl(){
		return starredUrl;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public String getLogin(){
		return login;
	}



	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}


	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}



	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setGravatarId(String gravatarId){
		this.gravatarId = gravatarId;
	}

	public String getGravatarId(){
		return gravatarId;
	}



	@Override
 	public String toString(){
		return 
			"Owner{" + 

			",repos_url = '" + reposUrl + '\'' + 

			",starred_url = '" + starredUrl + '\'' + 
			",login = '" + login + '\'' + 

			",url = '" + url + '\'' + 

			",avatar_url = '" + avatarUrl + '\'' + 

			",id = '" + id + '\'' + 
			",gravatar_id = '" + gravatarId + '\'' + 

			"}";
		}
}