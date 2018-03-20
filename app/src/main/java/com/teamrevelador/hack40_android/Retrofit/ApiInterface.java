package com.teamrevelador.hack40_android.Retrofit;

import android.widget.Toast;

import com.teamrevelador.hack40_android.Retrofit.Responses.HomeMonumentResponse;
import com.teamrevelador.hack40_android.Retrofit.Responses.SignUpResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
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

    @FormUrlEncoded
    @POST("tourist/api.php")
    Call<SignUpResponse> postFeedback (
            @Field("feedback") String feedback,
            @Field("user_id") String userId,
            @Field("monument_name") String monumentName,
            @Field("feedback_msg") String feedbackMessage,
            @Field("transit_via") String transitVia,
            @Field("rating") String rating
    );


//    ApiClient apiClient1 = new ApiClient();
//
//        apiClient1.getApiInterface().postFeedback(FEEDBACK , "6",MONUMENTNAME,FEEDBACKMESSAGE,TRANSITVIA,RATING)
//                .enqueue(new Callback<SignUpResponse>() {
//        @Override
//        public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
//            Toast.makeText(getContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onFailure(Call<SignUpResponse> call, Throwable t) {
//
//        }
//    });
}
