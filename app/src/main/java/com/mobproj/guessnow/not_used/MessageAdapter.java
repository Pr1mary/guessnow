//package com.mobproj.guessnow.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.gameroom.Model.Chat;
//import com.example.gameroom.R;
//
//import java.util.List;
//
//
//
//public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
//
//    public static final int MSG_TYPE_LEFT = 0;
//    public static final int MSG_TYPE_RIGHT = 1;
//
//    private Context mContext;
//    private List<Chat> mChat;
//    private String imageurl;
//
//    public MessageAdapter(Context mContext, List<Chat> mChat, String imageurl){
//        this.mChat = mChat;
//        this.mContext = mContext;
//        this.imageurl = imageurl;
//    }
//
//    @NonNull
//    @Override
//    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(viewType == MSG_TYPE_RIGHT) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false);
//            return new MessageAdapter.ViewHolder(view);
//        } else {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false);
//            return new MessageAdapter.ViewHolder(view);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
//
//        Chat chat = mChat.get(position);
//
//        holder.show_message.setText(chat.getMessage());
//
//        if(imageurl.equals("default")){
//            holder.profile_image.setImageResource(R.mipmap.ic_launcher);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mChat.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder{
//
//            public TextView show_message;
//            public ImageView profile_image;
//
//            public ViewHolder(View itemView) {
//                super(itemView);
//
//                show_message = itemView.findViewById(R.id.show_message);
//            }
//        }
//    }
//}
