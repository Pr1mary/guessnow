
//package com.mobproj.guessnow.not_used;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.TextView;
//
//import com.mobproj.guessnow.R;
//
//import java.util.List;
//
//
//public class GameRoom_temp extends Fragment {
//
//    TextView username;
//    ImageButton btn_send;
//    EditText text_send;
//
//    com.example.gameroom.Adapter.MessageAdapter messageAdapter;
//    List<Chat> mchat;
//
//    RecyclerView recyclerView;
//
//    Intent intent;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        recyclerView = findViewById(R.id.recyler_view);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        btn_send = findViewById(R.id.btn_send);
//        text_send = findViewById(R.id.text_send);
//
//        btn_send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String msg = text_send.getText().toString();
//                text_send.setText("");
//            }
//        });
//    }
//
//    public GameRoom_temp() {
//        // Required empty public constructor
//    }
//
//
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//
//        return inflater.inflate(R.layout.fragment_game_room, container, false);
//    }
//
//
//}
