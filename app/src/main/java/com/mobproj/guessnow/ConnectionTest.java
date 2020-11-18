package com.mobproj.guessnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ConnectionTest extends AppCompatActivity {

    private Socket msocket;
    {
        try{
            msocket = IO.socket("http://chat.socket.io");
        } catch(URISyntaxException e){}
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);
    }
}