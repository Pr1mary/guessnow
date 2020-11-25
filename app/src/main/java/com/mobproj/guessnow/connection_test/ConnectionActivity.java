package com.mobproj.guessnow.connection_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.engineio.client.Transport;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Manager;
import com.github.nkzawa.socketio.client.Socket;
import com.mobproj.guessnow.R;

import org.json.JSONObject;

import java.net.URISyntaxException;

public class ConnectionActivity extends AppCompatActivity {

    private Socket socket;
    private EditText inputMsgView;
    private String inputMsg, URL = "http://192.168.18.163:3000", room = "789";

    private Emitter.Listener newMsg = args -> {
        this.runOnUiThread(() -> {
//            JSONObject data = (JSONObject) args[0];
        });
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);

        inputMsgView = (EditText) findViewById(R.id.msg_input);
        try {
            socket = IO.socket("http://192.168.18.163:3000");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        socket.on(room, newMsg);
        socket.connect();

    }

    public void sendBtn(View view) {
        inputMsg = inputMsgView.getText().toString();
        if(TextUtils.isEmpty(inputMsg))
            return;

        inputMsgView.getText().clear();
        socket.emit(room, inputMsg);
    }
}