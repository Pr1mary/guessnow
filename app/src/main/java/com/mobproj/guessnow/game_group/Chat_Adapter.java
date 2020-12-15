package com.mobproj.guessnow.game_group;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobproj.guessnow.R;

import java.util.ArrayList;
import java.util.List;

public class Chat_Adapter extends RecyclerView.Adapter<Chat_Adapter.ChatHolder> {

    static List<String> nameList = new ArrayList<>();
    static List<String> chatList = new ArrayList<>();

    public static class ChatHolder extends RecyclerView.ViewHolder {

        private TextView usrList;
        private TextView chatList;

        public ChatHolder(@NonNull View itemView) {
            super(itemView);
            usrList = itemView.findViewById(R.id.idTag);
            chatList = itemView.findViewById(R.id.chatTag);

        }

        public TextView getUsrList() { return usrList; }
        public TextView getChatList(){
            return chatList;
        }
    }

    @Override
    public int getItemViewType(int position) { return R.layout.chat_item; }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {

        holder.getUsrList().setText(nameList.get(position)+": ");
        holder.getChatList().setText(chatList.get(position));
    }

    @Override
    public int getItemCount() { return nameList.size(); }

    public void updateChat(ArrayList<String> nameListUpdate, ArrayList<String> msgListUpdate){
        nameList.clear();
        chatList.clear();
        nameList.addAll(nameListUpdate);
        chatList.addAll(msgListUpdate);
        notifyDataSetChanged();
    }

}
