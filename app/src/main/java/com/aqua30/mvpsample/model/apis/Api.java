package com.aqua30.mvpsample.model.apis;

import com.aqua30.mvpsample.model.pojo.ArticleModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Saurabh(aqua) on 07-03-2016.
 */
public interface Api {

    /* @status unknown
     * on sending categories it is not returning articles. for each category, it is
     * sending a null article. */
    @POST("get_article_list/")
    Call<ArticleModel> getNewsArticle(@Body JsonObject body);

}