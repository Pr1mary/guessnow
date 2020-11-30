package com.mobproj.guessnow.not_used;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobproj.guessnow.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_game_info, parent, false);
        return new ListViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return User.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mItemName;
        private TextView mItemScore;

        public ListViewHolder(View itemView){
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.Name);
            mItemScore = (TextView) itemView.findViewById(R.id.Score);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemName.setText(User.title[position]);
            mItemScore.setText(User.title[position]);
        }

        public void onClick(View view){

        }

    }

}

