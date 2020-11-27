package com.mobproj.guessnow.connection_test;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketIO_Connection {

    private Socket socket;

    public void connect(String URL){
        try {
            socket = IO.socket(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();
    }

    public void emit(){
    }
}
