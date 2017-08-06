package com.aqua30.mvpsample.model.apis;

import com.aqua30.mvpsample.model.pojo.ArticleModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;


public class DataRepository {

    public static Call<ArticleModel> getArticles(){
        Api api = RestApiObject.getInstance();
        JsonObject body = new JsonObject();
        body.addProperty("user_id","DGUSR1");
        JsonArray category_array = new JsonArray();
        body.add("categories",category_array);
        return api.getNewsArticle(body);
    }

}