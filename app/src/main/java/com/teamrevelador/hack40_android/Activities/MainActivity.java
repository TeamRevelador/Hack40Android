package com.teamrevelador.hack40_android.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.teamrevelador.hack40_android.Fragments.HomeFragment;
import com.teamrevelador.hack40_android.Fragments.ProfileFragment;
import com.teamrevelador.hack40_android.R;

public class MainActivity extends AppCompatActivity {

    BottomSheetLayout bottomSheet;
    Toolbar toolbar;
    TextView toolbarText;
    FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_profile:
                    setFragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemBackgroundResource(R.color.toolbar_title_color);

        navigation.setSelectedItemId(R.id.navigation_home);

        bottomSheet = findViewById(R.id.bottomsheet);
        toolbarText = toolbar.findViewById(R.id.main_toolbar_text);

//        b.setOnClickListener(new View.OnClickListener()
//
//        {
//            @Override
//            public void onClick(View view) {
                /* BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                 View parentView = getLayoutInflater().inflate(R.layout.dilog,null);
                 bottomSheetDialog.setContentView(parentView);
                 BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View)parentView.getParent());
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                 bottomSheetDialog.show();*/

        View parentView = getLayoutInflater().inflate(R.layout.monument_collapsing, null);
        bottomSheet.showWithSheetView(LayoutInflater
                .from(getBaseContext())
                .inflate(R.layout.monument_collapsing, bottomSheet, false));

        bottomSheet.dismissSheet();

//        Toolbar toolbar = parentView.findViewById(R.id.toolbar);


//        String title = "kk";  // Todo remove this title
//
//        ((CollapsingToolbarLayout) findViewById(R.id.toolbar_layout)).setTitle(title);

        //            }
        //        });

    }

    private void setFragment(Fragment fragment) {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        if (fragmentManager.getFragments().isEmpty())
            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.main_container, fragment, "Main")
                    .addToBackStack("Main")
                    .commit();

        else
            fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.main_container, fragment, "Main")
                    .addToBackStack("Main")
                    .commit();

    }

}
