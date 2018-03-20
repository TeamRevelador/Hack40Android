package com.teamrevelador.hack40_android.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
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




//        LayoutInflater layoutInflater=getLayoutInflater();
//        View v=layoutInflater.inflate(R.layout.feedback_dynamic_rating,null);
//        ViewGroup main= findViewById(R.id.scroll_dynamic_container);
//        main.addView(v,0);




    }}

