package com.teamrevelador.hack40_android.Retrofit;

import com.teamrevelador.hack40_android.Retrofit.Responses.HomeMonumentResponse;
import com.teamrevelador.hack40_android.Retrofit.Responses.SignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public interface ApiInterface {

    @Multipart

    @POST("tourist/api.php")
    Call<SignUpResponse> signUpRequest(
            @Part("name") RequestBody name,
            @Part("email") RequestBody email,
            @Part("age") RequestBody age,
            @Part("gender") RequestBody gender,
            @Part("password") RequestBody password,
            @Part MultipartBody.Part image,
            @Part("registration") RequestBody registration
    );

    @FormUrlEncoded
    @POST("tourist/api.php")
    Call<List<HomeMonumentResponse>> getHomeMonuments(
            @Field("monuments_detail") String number
    );

}
