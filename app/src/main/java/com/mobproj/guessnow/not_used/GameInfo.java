package com.mobproj.guessnow.not_used;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobproj.guessnow.R;
import com.mobproj.guessnow.home_group.MainActivity;

import java.util.ArrayList;

public class GameInfo extends AppCompatActivity {
    private ArrayList<User> list;
    private RecyclerView recycler;
    private UserAdapter.clikListener listener;
    private Button GameInfo, GameRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
//        GameInfo = findViewById(R.id.GameInfo);
//        GameInfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ganti1 = new Intent(GameInfo.this,GameInfo.class);
//                startActivity(ganti1);
//            }
//        });
//        GameRoom = findViewById(R.id.GameRoom);
//        GameRoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ganti2 = new Intent(GameInfo.this,GameRoom.class);
//                startActivity(ganti2);
//            }
//        });
//
//        recycler = findViewById(R.id.);
//        list = new ArrayList<>();
//
//        list.add(new User("1.UserOne","15",R.drawable.1));
//        list.add(new User("2.Ricky","10",R.drawable.2);
//        list.add(new User("3.Anthony9","25",R.drawable.3));
//        list.add(new User("4.Johnjohnny","10",R.drawable.4));
//        list.add(new User("5.Mystic","30",R.drawable.5));
//        list.add(new User("6.Noname","0",R.drawable.6));
//
//        adapterr();
//    }
    private void adapterr() {

        listener = new UserAdapter.clikListener() {
            @Override
            public void onClik(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), GameInfo.class);
                intent.putExtra("nama", list.get(position).getNama());
                intent.putExtra("score", list.get(position).getScore());
                startActivity(intent);
            }
        };


        UserAdapter adapter = new UserAdapter(list, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter );
    }
}