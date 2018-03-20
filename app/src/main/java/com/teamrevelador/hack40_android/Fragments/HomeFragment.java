package com.teamrevelador.hack40_android.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.gson.annotations.SerializedName;
import com.teamrevelador.hack40_android.Adapters.HomeAdapter;
import com.teamrevelador.hack40_android.Models.HomeMonumentModel;
import com.teamrevelador.hack40_android.R;
import com.teamrevelador.hack40_android.Retrofit.ApiClient;
import com.teamrevelador.hack40_android.Retrofit.Responses.HomeMonumentResponse;
import com.teamrevelador.hack40_android.Retrofit.Responses.SignUpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<HomeMonumentResponse> arrayList = new ArrayList<>();
    SliderLayout mSliderLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        mSliderLayout = (SliderLayout) view.findViewById(R.id.home_fragment_slider);


        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(true);
        progressDialog.setMessage("Fetching most rated monuments");
        progressDialog.setTitle("Please wait");
        progressDialog.show();


//        for(int i =0;i<10;i++)
//            arrayList.add(new HomeMonumentResponse("name" + i, "lat" + i, "lng" + i, "desc" + i, "photo" + i, "4", "visit" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i, "fact" + i));



        ApiClient apiClient = new ApiClient();

        apiClient.getApiInterface()
                .getHomeMonuments("1")
                .enqueue(new Callback<List<HomeMonumentResponse>>() {
                    @Override
                    public void onResponse(Call<List<HomeMonumentResponse>> call, Response<List<HomeMonumentResponse>> response) {
                        for(HomeMonumentResponse homeMonumentResponse : response.body()) {
                            arrayList.add(homeMonumentResponse);
                            Log.d("TAG",homeMonumentResponse.getDescription());
                        }
                        progressDialog.dismiss();
                        homeAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<List<HomeMonumentResponse>> call, Throwable t) {

                    }
                });

                HashMap < String, Integer > file_maps = new HashMap<String, Integer>();
        file_maps.put("Amber Fort", R.drawable.amber_fort);
        file_maps.put("Amer Fort", R.drawable.amer_palace_jaipur);
        file_maps.put("Jaigarh", R.drawable.jaigarh_image);
        file_maps.put("Jaipur Image", R.drawable.jaipur_image);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
//            initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
//
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
//
            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);

//
//        for (int i = 0; i < 10; i++) {
//            arrayList.add(new HomeMonumentModel("Monument " + i, "Visits " + i, "Distance is " + i, "4", "Description " + i, "URL " + i));
//        }

//        this.monumentName = monumentName;
//        this.monumentVisits = monumentVisits;
//        this.monumentDistance = monumentDistance;
//        this.monumentRatingText = monumentRatingText;
//        this.monumentDescription = monumentDescription;
//        this.monuementImageUrl = monuementImageUrl;

        recyclerView = view.findViewById(R.id.home_fragment_recycler_view);
        homeAdapter = new HomeAdapter(getContext(), arrayList);
        recyclerView.setAdapter(homeAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        homeAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        return view;
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getContext(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Toast.makeText(getContext(), "pageScrolled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}


