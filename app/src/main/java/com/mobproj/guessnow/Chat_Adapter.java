package com.mobproj.guessnow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class Chat_Adapter extends RecyclerView.Adapter<Chat_Adapter.ChatHolder> {

    String nameList[] = {"Nino","Mustang","Ladu"};
    String chatList[] = {"soso", "toto", "mama"};

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
        ChatHolder vh = new ChatHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, int position) {
        holder.getUsrList().setText(nameList[position]+": ");
        holder.getChatList().setText(chatList[position]);

    }

    @Override
    public int getItemCount() {
        return nameList.length;
    }
}
