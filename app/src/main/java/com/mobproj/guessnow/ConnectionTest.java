package com.mobproj.guessnow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import com.github.nkzawa.emitter.Emitter;
//import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ConnectionTest extends AppCompatActivity {


//
//    private Emitter.Listener onNewMessage = args -> this.runOnUiThread(() -> {
//        JSONObject data = (JSONObject) args[0];
//        String username;
//        String message;
//        try {
//            username = data.getString("username");
//            message = data.getString("message");
//        } catch (JSONException e) {
//            return;
//        }
//
//        // add the message to view
////        addMessage(username, message);
//    });

    Socket socket;
    {
        try {
            socket = IO.socket("http://192.168.18.163:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);

//        msocket.on("123", onNewMessage);
//        msocket.connect();

        socket.on(Socket.EVENT_CONNECT, args -> {
            socket.emit("789", "test");
        }).on("789", args -> {}).on(Socket.EVENT_DISCONNECT, args -> {});
        socket.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        msocket.disconnect();
//        msocket.off("123", onNewMessage);
    }
}