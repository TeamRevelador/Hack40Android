package com.teamrevelador.hack40_android.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.teamrevelador.hack40_android.R;
import com.teamrevelador.hack40_android.Retrofit.ApiClient;
import com.teamrevelador.hack40_android.Retrofit.Responses.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kushalgupta on 19/03/18.
 */

public class FeedbackPage1 extends AppCompatActivity {
    EditText homeTown, monumentName, feedback01, monumentName2, feedback02, monumentName3, feedback03, monumentName4, feedback04, monumentName5, feedback05;
    RatingBar r1, r2, r3, r4, r5;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page1);


        Spinner sp1 = findViewById(R.id.spinner1);
        btn = findViewById(R.id.button);

        if ("car" == String.valueOf(sp1.getSelectedItem())) {
            Toast.makeText(getApplicationContext(), "car", Toast.LENGTH_SHORT).show();
        }
//TextView tt=findViewById(R.id.textView5);
//        final RelativeLayout rl = findViewById(R.id.dynamic_container);
//        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT);
//        lp.addRule(RelativeLayout.BELOW,tt.getId());
//        final LayoutInflater layoutInflater=getLayoutInflater();
//        View v=layoutInflater.inflate(R.layout.feedback_dynamic_rating1,null);
//        rl.addView(v,lp);
//anotherFeedback.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        EditText et1=findViewById(R.id.et_feedback1);
//        lp.addRule(RelativeLayout.BELOW,et1.getId());
//        View v2=layoutInflater.inflate(R.layout.feedback_dynamic_rating2,null);
//        rl.addView(v2,lp);
//    }
//});
        homeTown = findViewById(R.id.editText);
        String home = homeTown.getText().toString();
        final String transitVia = String.valueOf(sp1.getSelectedItem());
        monumentName = findViewById(R.id.et_place_visited);
        final String placeVisited1 = monumentName.getText().toString();

        r1 = findViewById(R.id.ratingBar);
        final String rating1 = String.valueOf(r1.getNumStars());
        feedback01 = findViewById(R.id.et_feedback1);
        String Feedback1 = feedback01.getText().toString();

        monumentName2 = findViewById(R.id.et_place_visited2);
        final String placeVisited2 = monumentName2.getText().toString();

        r2 = findViewById(R.id.ratingBar2);
        final String rating2 = String.valueOf(r2.getNumStars());
        feedback02 = findViewById(R.id.et_feedback2);
        String Feedback2 = feedback02.getText().toString();

        monumentName3 = findViewById(R.id.et_place_visited3);
        final String placeVisited3 = monumentName3.getText().toString();

        r3 = findViewById(R.id.ratingBar3);
        final String rating3 = String.valueOf(r3.getNumStars());
        feedback03 = findViewById(R.id.et_feedback3);
        String Feedback3 = feedback03.getText().toString();

        monumentName4 = findViewById(R.id.et_place_visited4);
        final String placeVisited4 = monumentName4.getText().toString();

        r4 = findViewById(R.id.ratingBar4);
        final String rating4 = String.valueOf(r4.getNumStars());
        feedback04 = findViewById(R.id.et_feedback4);
        String Feedback4 = feedback04.getText().toString();


        monumentName5 = findViewById(R.id.et_place_visited5);
        final String placeVisited5 = monumentName5.getText().toString();

        r5 = findViewById(R.id.ratingBar5);
        final String rating5 = String.valueOf(r5.getNumStars());
        feedback05 = findViewById(R.id.et_feedback5);
        String Feedback5 = feedback05.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiClient apiClient1 = new ApiClient();
                String FEEDBACK = String.valueOf(1);
                apiClient1.getApiInterface().postFeedback(FEEDBACK, "6", placeVisited1, feedback01.getText().toString(), transitVia, rating1)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                Toast.makeText(getApplicationContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }


                        });
                ApiClient apiClient2 = new ApiClient();
                String FEEDBACK2 = String.valueOf(1);
                apiClient1.getApiInterface().postFeedback(FEEDBACK, "6", placeVisited2, feedback02.getText().toString(), transitVia, rating2)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                Toast.makeText(getApplicationContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }

        });

                ApiClient apiClient3 = new ApiClient();
                String FEEDBACK3 = String.valueOf(1);
                apiClient1.getApiInterface().postFeedback(FEEDBACK, "6", placeVisited3, feedback03.getText().toString(), transitVia, rating3)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                Toast.makeText(getApplicationContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }});
                ApiClient apiClient4 = new ApiClient();
                String FEEDBACK4 = String.valueOf(1);
                apiClient1.getApiInterface().postFeedback(FEEDBACK, "6", placeVisited4, feedback04.getText().toString(), transitVia, rating4)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                Toast.makeText(getApplicationContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }});
                ApiClient apiClient5 = new ApiClient();

                apiClient1.getApiInterface().postFeedback(FEEDBACK, "6", placeVisited5, feedback05.getText().toString(), transitVia, rating5)
                        .enqueue(new Callback<SignUpResponse>() {
                            @Override
                            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                                Toast.makeText(getApplicationContext(), "FEEDBACK SUBMITTED, THANK YOU", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                            }});
//        LayoutInflater layoutInflater=getLayoutInflater();
//        View v=layoutInflater.inflate(R.layout.feedback_dynamic_rating,null);
//        ViewGroup main= findViewById(R.id.scroll_dynamic_container);
//        main.addView(v,0);


    }
});
    }
}

