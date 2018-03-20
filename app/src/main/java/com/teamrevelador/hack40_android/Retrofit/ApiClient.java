package com.teamrevelador.hack40_android.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class ApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.26.58.197/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    public Retrofit getRetrofit() {
        return retrofit;
    }

    ApiInterface apiInterface = retrofit.create(ApiInterface.class);

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
