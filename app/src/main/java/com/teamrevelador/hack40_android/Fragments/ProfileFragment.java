package com.teamrevelador.hack40_android.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.teamrevelador.hack40_android.Activities.RewardsActivity;
import com.teamrevelador.hack40_android.Constants.SharedPreferencesConstants;
import com.teamrevelador.hack40_android.R;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_fragment_layout,container,false);

        TextView nameTextView = view.findViewById(R.id.profile_user_name_text_view);
        TextView ageTextView = view.findViewById(R.id.profile_user_age_text_view);
        TextView genderTextView = view.findViewById(R.id.profile_user_gender_text_view);
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SharedPreferencesConstants.prefsName, Context.MODE_PRIVATE);
        nameTextView.setText(sharedPreferences.getString(SharedPreferencesConstants.prefsUserName,""));
        ageTextView.setText(sharedPreferences.getString(SharedPreferencesConstants.prefsUserAge,""));
        genderTextView.setText(sharedPreferences.getString(SharedPreferencesConstants.prefsUserGender,""));




        Button button = view.findViewById(R.id.profile_get_rewards_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RewardsActivity.class));
            }
        });



        return view;

    }
}
