package com.mobproj.guessnow.game_group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobproj.guessnow.R;

import java.util.ArrayList;

public class LB_Adapter extends RecyclerView.Adapter<LB_Adapter.LB_Holder> {

    Integer score = 10;

    ArrayList<String> nameList = new ArrayList<>();

    public static class LB_Holder extends RecyclerView.ViewHolder {

        private TextView lbList;

        public LB_Holder(@NonNull View itemView) {
            super(itemView);
            lbList = itemView.findViewById(R.id.lbList);

        }

        public TextView getLbList(){
            return lbList;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.leaderboard_item;
    }

    @NonNull
    @Override
    public LB_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        LB_Holder vh = new LB_Holder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull LB_Holder holder, int position) {
        holder.getLbList().setText(nameList.get(position)+": "+position*score);

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void updateData(ArrayList<String> nameListUpdate){
        nameList.clear();
        nameList.addAll(nameListUpdate);
        notifyDataSetChanged();
    }

}
