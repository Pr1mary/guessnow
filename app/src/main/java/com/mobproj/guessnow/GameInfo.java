package com.mobproj.guessnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameInfo extends AppCompatActivity {
    private Button GameInfo, GameRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        GameInfo = findViewById(R.id.GameInfo);
        GameInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti1 = new Intent(MainActivity.this,GameInfo.class);
                startActivity(ganti1);
            }
        });
        GameRoom = findViewById(R.id.GameRoom);
        GameRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti2 = new Intent(MainActivity.this,GameRoom.class);
                startActivity(ganti2);
            }
        });
    }
}