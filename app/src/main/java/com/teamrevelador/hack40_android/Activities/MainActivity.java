package com.teamrevelador.hack40_android.Activities;

import android.Manifest;
import android.content.Intent;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.teamrevelador.hack40_android.Fragments.AboutFragment;
import com.teamrevelador.hack40_android.Fragments.FeedbackPage1;
import com.teamrevelador.hack40_android.Fragments.HomeFragment;
import com.teamrevelador.hack40_android.Fragments.ProfileFragment;
import com.teamrevelador.hack40_android.R;
import com.teamrevelador.hack40_android.Retrofit.ApiClient;
import com.teamrevelador.hack40_android.Retrofit.ApiInterface;
import com.teamrevelador.hack40_android.Retrofit.Responses.HomeMonumentResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    BottomSheetLayout bottomSheet;
    Toolbar toolbar;
    TextView toolbarText;
    FragmentManager fragmentManager;
    LocationManager locationManager;
    LocationListener listener;
    Boolean GpsEnabled = false;
    Boolean NetworkProvider = false;
    public static final String TAG = "loc";
    Boolean backTappedOnce = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(new HomeFragment());
                    return true;
                case R.id.navigation_about:
                    setFragment(new AboutFragment());
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

        toolbarText = toolbar.findViewById(R.id.main_toolbar_text);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String latitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());
                Log.d(TAG, "onLocationChanged: "+latitude);
                //Todo - send location on server


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Toast.makeText(MainActivity.this, "Please switch your location on", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);

            }

        };

        sendLocationOnServer();

    }




    private void sendLocationOnServer() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please grant location permisission for the app", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }

            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        GpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        NetworkProvider = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (GpsEnabled) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100000, 0, listener);
        } else if (NetworkProvider) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100000, 0, listener);


        }

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Handler handler = new Handler();

        if (backTappedOnce)
            finish();

        backTappedOnce = true;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                backTappedOnce = false;
            }
        }, 2000);
    }
}
