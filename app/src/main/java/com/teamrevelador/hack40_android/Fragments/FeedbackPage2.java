package com.teamrevelador.hack40_android.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamrevelador.hack40_android.R;

/**
 * Created by kushalgupta on 20/03/18.
 */

public class FeedbackPage2 extends AppCompatActivity {

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.feedback_page2, container, false);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page2);


    LayoutInflater layoutInflater=getLayoutInflater();
        View v=layoutInflater.inflate(R.layout.feedback_dynamic_rating,null);
        ViewGroup main= findViewById(R.id.scroll_dynamic_container);
        main.addView(v,0);


}}
