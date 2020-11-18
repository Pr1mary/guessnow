package com.mobproj.guessnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class ConnectionTest extends AppCompatActivity {

    private Socket msocket;
    {
        try{
            msocket = IO.socket("http://localhost:3000");
        } catch(URISyntaxException e){}
    }

    private Emitter.Listener onNewMessage = args -> this.runOnUiThread(() -> {
        JSONObject data = (JSONObject) args[0];
        String username;
        String message;
        try {
            username = data.getString("username");
            message = data.getString("message");
        } catch (JSONException e) {
            return;
        }

        // add the message to view
//        addMessage(username, message);
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);

        msocket.on("123", onNewMessage);
        msocket.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        msocket.disconnect();
        msocket.off("123", onNewMessage);
    }
}