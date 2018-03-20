package com.teamrevelador.hack40_android.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamrevelador.hack40_android.R;

/**
 * Created by kushalgupta on 20/03/18.
 */

public class MonumentDescription extends AppCompatActivity {
    ImageView imageView;
    TextView tvMonumentName,description,facte1,facte2,facte3,facte4,facte5,facte6,facte7,facte8,facte9,facte10;
    RatingBar monumentRating;
    ImageButton directionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.monument_description);
    imageView=findViewById(R.id.iv_monument_pic);
    tvMonumentName = findViewById(R.id.textView6);
    monumentRating = findViewById(R.id.ratingBar);
    directionButton = findViewById(R.id.directions_rating_btn);
    description = findViewById(R.id.description);
    facte1 = findViewById(R.id.fact1);
        facte2 = findViewById(R.id.fact2);
        facte3 = findViewById(R.id.fact3);
        facte4 = findViewById(R.id.fact4);
        facte5 = findViewById(R.id.fact5);
        facte6 = findViewById(R.id.fact6);
        facte7 = findViewById(R.id.fact7);
        facte8 = findViewById(R.id.fact8);
        facte9 = findViewById(R.id.fact9);
        facte10 = findViewById(R.id.fact10);

        Bundle bundle = getIntent().getExtras();
        String monumentName = bundle.getString("monumentName");

    }
}
