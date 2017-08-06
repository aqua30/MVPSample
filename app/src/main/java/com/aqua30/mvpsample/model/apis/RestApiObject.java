package com.aqua30.mvpsample.model.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Saurabh(aqua) on 07-03-2016.
 */

public class RestApiObject {

    /*
    * Base url for apis
    * */
    public static final String BaseUrl = "http://development.easystartup.org/digest/backend/";
    private static Retrofit retrofit;

    public static Api getInstance(){
        if (retrofit == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(Api.class);
    }

}
