package com.teamrevelador.hack40_android.Activities;

import android.content.Intent;
import android.net.Uri;
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

import com.bumptech.glide.Glide;
import com.teamrevelador.hack40_android.R;

import java.util.Locale;

/**
 * Created by kushalgupta on 20/03/18.
 */

public class MonumentDescription extends AppCompatActivity {
    ImageView imageView;
    TextView tvMonumentName, Description, facte1, facte2, facte3, facte4, facte5, facte6, facte7, facte8, facte9, facte10;
    RatingBar monumentRating;
    ImageButton directionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monument_description);
        imageView = findViewById(R.id.iv_monument_pic);
        tvMonumentName = findViewById(R.id.textView6);
        monumentRating = findViewById(R.id.ratingBar);
        directionButton = findViewById(R.id.directions_rating_btn);
        Description = findViewById(R.id.description);
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
        final String latitude = bundle.getString("latitude");
        final String longitude = bundle.getString("longitude");
        String description = bundle.getString("description");
        String photo = bundle.getString("photoUrl");
        String rating = bundle.getString("rating");
        String visits = bundle.getString("visits");
        String fact1 = bundle.getString("fact1");
        String fact2 = bundle.getString("fact2");
        String fact3 = bundle.getString("fact3");
        String fact4 = bundle.getString("fact4");
        String fact5 = bundle.getString("fact5");
        String fact6 = bundle.getString("fact6");
        String fact7 = bundle.getString("fact7");
        String fact8 = bundle.getString("fact8");
        String fact9 = bundle.getString("fact9");
        String fact10 = bundle.getString("fact10");

Description.setText(description);
tvMonumentName.setText(monumentName);
        Glide.with(getApplicationContext()).load(photo).into(imageView);
        monumentRating.setNumStars(Integer.parseInt(rating));
        facte1.setText(fact1);
        facte2.setText(fact2);
        facte3.setText(fact3);
        facte4.setText(fact4);
        facte5.setText(fact5);
        facte6.setText(fact6);
        facte7.setText(fact7);
        facte8.setText(fact8);
        facte9.setText(fact9);
        facte10.setText(fact10);

        directionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });


    }
}
