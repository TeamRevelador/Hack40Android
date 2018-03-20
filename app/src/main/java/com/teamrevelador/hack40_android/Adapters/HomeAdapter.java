package com.teamrevelador.hack40_android.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.teamrevelador.hack40_android.Activities.MonumentDescription;
import com.teamrevelador.hack40_android.Activities.SignUpActivity;
import com.teamrevelador.hack40_android.Models.HomeMonumentModel;
import com.teamrevelador.hack40_android.R;
import com.teamrevelador.hack40_android.Retrofit.Responses.HomeMonumentResponse;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


    private Context mContext;
    private ArrayList<HomeMonumentResponse> arrayList;

    public HomeAdapter(Context mContext, ArrayList<HomeMonumentResponse> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.monumentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Helo " + position, Toast.LENGTH_SHORT).show();
             String Monumentname=  arrayList.get(position).getName();
             String lati=arrayList.get(position).getLatitude();
             String loni=arrayList.get(position).getLongitude();
             String descrip=arrayList.get(position).getDescription();
             String photo=arrayList.get(position).getPhoto();
             String rat=arrayList.get(position).getRating();
             String ftaco1=arrayList.get(position).getFact1();
                String ftaco2=arrayList.get(position).getFact2();
                String ftaco3=arrayList.get(position).getFact3();
                String ftaco4=arrayList.get(position).getFact4();
                String ftaco5=arrayList.get(position).getFact5();
                String ftaco6=arrayList.get(position).getFact6();
                String ftaco7=arrayList.get(position).getFact7();
                String ftaco8=arrayList.get(position).getFact8();
                String ftaco9=arrayList.get(position).getFact9();
                String ftaco10=arrayList.get(position).getFact10();


                Bundle bundle=new Bundle();
                bundle.putString("monumentName",Monumentname);
                bundle.putString("latitude",lati);
                bundle.putString("longitude",loni);
                bundle.putString("description",descrip);
                bundle.putString("photoUrl",photo);
                bundle.putString("rating",rat);
                bundle.putString("fact1",ftaco1);
                bundle.putString("fact2",ftaco2);
                bundle.putString("fact3",ftaco3);
                bundle.putString("fact4",ftaco4);
                bundle.putString("fact5",ftaco5);
                bundle.putString("fact6",ftaco6);
                bundle.putString("fact7",ftaco7);
                bundle.putString("fact8",ftaco8);
                bundle.putString("fact9",ftaco9);
                bundle.putString("fact10",ftaco10);



                Intent intent = new Intent(mContext, MonumentDescription.class);
mContext.startActivity(intent);

//                TODO :  add code to show the bottomsheet here and networking ka code bhi idhr hi ayega wo main kr dunga bad mein
            }
        });
        holder.monumentVisitsTextView.setText(arrayList.get(position).getVisits());
        holder.monumentRatingTextView.setText(arrayList.get(position).getRating());
        holder.monumentNameTextView.setText(arrayList.get(position).getName());
        holder.monumentRatingBar.setNumStars(Integer.parseInt(arrayList.get(position).getRating()));
        holder.monumentDescriptionTextView.setText(arrayList.get(position).getDescription());
//        holder.monumentCircleImageView.setText(arrayList.get(position).getMonumentVisits());
//        holder.monumentVisitsTextView.setText(arrayList.get(position).getMonumentVisits());TODO: Calculate the distance from current loc


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        View monumentItemView;
        TextView monumentNameTextView;
        TextView monumentDistanceTextView;
        TextView monumentDescriptionTextView;
        TextView monumentRatingTextView;
        TextView monumentVisitsTextView;
        MaterialRatingBar monumentRatingBar;
        CircleImageView monumentCircleImageView;


        public MyViewHolder(View itemView) {
            super(itemView);

            monumentItemView = itemView;
            monumentDescriptionTextView = itemView.findViewById(R.id.monument_description_text_view);
            monumentDistanceTextView = itemView.findViewById(R.id.monument_distance_text_view);
            monumentCircleImageView = itemView.findViewById(R.id.monument_circle_image_view);
            monumentNameTextView = itemView.findViewById(R.id.monument_name_text_view);
            monumentRatingBar = itemView.findViewById(R.id.monument_rating_bar);
            monumentRatingTextView = itemView.findViewById(R.id.monument_rating_text);
            monumentVisitsTextView = itemView.findViewById(R.id.monument_visits_text_view);
        }
    }
}
