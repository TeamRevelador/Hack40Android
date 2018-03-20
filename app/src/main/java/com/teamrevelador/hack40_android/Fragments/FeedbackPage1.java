package com.teamrevelador.hack40_android.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.teamrevelador.hack40_android.R;

/**
 * Created by kushalgupta on 19/03/18.
 */

public class FeedbackPage1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page1);


        Spinner sp1 = findViewById(R.id.spinner1);


        if ("car" == String.valueOf(sp1.getSelectedItem())) {
            Toast.makeText(getApplicationContext(), "car", Toast.LENGTH_SHORT).show();
        }


    Button bo = findViewById(R.id.btf1);
        bo.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(FeedbackPage1.this, FeedbackPage2.class);
        startActivity(intent);

    }
    });

    }}

