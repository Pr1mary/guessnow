package com.mobproj.guessnow;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CentralProcess {

    private static Socket socket;
    private static Integer roomID;

    public static void connectServer(String serverURL){

        try {
            socket = IO.socket(serverURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();

    }

    public static void disconnectServer(){
        socket.disconnect();
    }

    public static void sendMsg(String room, String msg, String userID){
        JSONObject msgObj = new JSONObject();

        try {
            msgObj.put("user", userID);
            msgObj.put("msg", msg);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.emit(room, msgObj);
    }



    public static List<String> showChat(){
        ArrayList<String> chatList = new ArrayList<>();
        return chatList;
    }

    public static Integer getRoomID() {
        return roomID;
    }

    public static void setRoomID(Integer roomID) {
        CentralProcess.roomID = roomID;
    }
}
