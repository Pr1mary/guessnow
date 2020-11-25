package com.mobproj.guessnow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> list;

    private clikListener listener;

    public UserAdapter(ArrayList<User> list, clikListener listener){
        this.listener = listener;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private TextView Nama;
        private TextView Score;


        public ViewHolder(final View view){
            super(view);
            Nama = view.findViewById(R.id.nama);
            Score = view.findViewById(R.id.score);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClik(view, getAdapterPosition());
        }
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemV = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_game_info, parent, false);
        return new ViewHolder(itemV);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        String nama = list.get(position).getNama();
        String score = list.get(position).getScore();

        holder.Nama.setText(nama);
        holder.Score.setText(score);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface clikListener{
        void onClik(View v, int position);
    }
}

