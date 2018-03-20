package com.teamrevelador.hack40_android.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teamrevelador.hack40_android.Activities.RewardsActivity;
import com.teamrevelador.hack40_android.R;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class AboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.about_layout,container,false);


        return view;
    }
}
