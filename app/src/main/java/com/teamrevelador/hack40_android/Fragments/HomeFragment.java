package com.teamrevelador.hack40_android.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamrevelador.hack40_android.Adapters.HomeAdapter;
import com.teamrevelador.hack40_android.Models.HomeMonumentModel;
import com.teamrevelador.hack40_android.R;

import java.util.ArrayList;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    ArrayList<HomeMonumentModel> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout,container,false);

        for(int i =0 ; i < 10;i++){
            arrayList.add(new HomeMonumentModel("Monument "+i,"Visits "+i,"Distance is "+i,"4","Description "+i,"URL "+i));
        }

//        this.monumentName = monumentName;
//        this.monumentVisits = monumentVisits;
//        this.monumentDistance = monumentDistance;
//        this.monumentRatingText = monumentRatingText;
//        this.monumentDescription = monumentDescription;
//        this.monuementImageUrl = monuementImageUrl;

        recyclerView=view.findViewById(R.id.home_fragment_recycler_view);
        homeAdapter = new HomeAdapter(getContext(),arrayList);
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
}
