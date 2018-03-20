package com.teamrevelador.hack40_android.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.flipboard.bottomsheet.BottomSheetLayout;
import com.teamrevelador.hack40_android.Models.HomeMonumentModel;
import com.teamrevelador.hack40_android.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by anubhavmalik on 19/03/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {


    private Context mContext;
    private ArrayList<HomeMonumentModel> arrayList;


    public HomeAdapter(Context mContext, ArrayList<HomeMonumentModel> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_item, parent, false));



    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.monumentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Helo " + position, Toast.LENGTH_SHORT).show();

//                bottomSheet.showWithSheetView(LayoutInflater
//                        .from(mContext)
//                        .inflate(R.layout.monument_collapsing, holder.bottomSheet, false));
//
//                holder.bottomSheet.dismissSheet();
//                TODO :  add code to show the bottomsheet here and networking ka code bhi idhr hi ayega wo main kr dunga bad mein
            }
        });
        holder.monumentVisitsTextView.setText(arrayList.get(position).getMonumentVisits());
        holder.monumentRatingTextView.setText(arrayList.get(position).getMonumentRatingText());
        holder.monumentNameTextView.setText(arrayList.get(position).getMonumentName());
        holder.monumentRatingBar.setNumStars(Integer.parseInt(arrayList.get(position).getMonumentRatingText()));
        holder.monumentDescriptionTextView.setText(arrayList.get(position).getMonumentDescription());
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
//BottomSheetLayout bottomSheet;
//        View parentView;
//        LayoutInflater layoutInflater;


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
//            bottomSheet = itemView.findViewById(R.id.bottomsheet);
//            layoutInflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
//            assert layoutInflater != null;
//            parentView= layoutInflater.inflate (R.layout.monument_collapsing, null);

        }
    }

}
