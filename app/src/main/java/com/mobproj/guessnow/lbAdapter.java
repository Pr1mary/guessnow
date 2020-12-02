package com.mobproj.guessnow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class lbAdapter extends RecyclerView.Adapter<lbAdapter.lbHolder> {

    String nameList[] = {"Joko","Susilo","Bambang"};
    Integer score = 10;

    public static class lbHolder extends RecyclerView.ViewHolder {

        private TextView lbList;

        public lbHolder(@NonNull View itemView) {
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

    @Override
    public lbHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        lbHolder vh = new lbHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull lbHolder holder, int position) {
        holder.getLbList().setText(nameList[position]+": "+position*score);
    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }
}
