package com.teamrevelador.hack40_android.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.teamrevelador.hack40_android.Activities.MonumentDescription;
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
