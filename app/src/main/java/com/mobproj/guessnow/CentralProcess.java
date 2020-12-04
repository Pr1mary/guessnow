package com.mobproj.guessnow;

import android.app.Activity;
import android.os.Debug;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CentralProcess {

    private static Socket socket;
    private static String roomID = "400694";

    private static String currUser = "Alice";

    public static ArrayList<String> userList = new ArrayList<>();
    public static ArrayList<String> userList_Chat = new ArrayList<>();
    public static ArrayList<String> msgList_Chat = new ArrayList<>();

    public static void connectServer(String serverURL, Activity act){

        try {
            socket = IO.socket(serverURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        socket.on(roomID+"-msg", args -> {
            act.runOnUiThread(() -> {
                JSONObject msgData = (JSONObject) args[0];
                String userID;
                String msg;
                try{
                    userID = msgData.getString("user");
                    msg = msgData.getString("msg");
                } catch (JSONException e) {
                    return;
                }
                userList_Chat.add(userID);
                msgList_Chat.add(msg);
                Log.d("username", userID);
                Log.d("message", msg);
                GameRoom_frg.dataUpdate(userList_Chat, msgList_Chat);
            });
        });
        socket.connect();

    }

    public static void disconnectServer(){
        socket.disconnect();
        socket.off(roomID+"-msg");
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


    public static String getRoomID() {
        return roomID;
    }

    public static void setRoomID(String roomID) {
        CentralProcess.roomID = roomID;
    }

    public static ArrayList<String> getUserList_Chat() {
        return userList_Chat;
    }

    public static ArrayList<String> getMsgList_Chat() {
        return msgList_Chat;
    }

    public static void clearChat() {
        if(!(userList_Chat.isEmpty() && msgList_Chat.isEmpty())){
            userList_Chat.clear();
            msgList_Chat.clear();
            GameRoom_frg.dataUpdate(userList_Chat, msgList_Chat);
        }
    }

    public static String getCurrUser() {
        return currUser;
    }

    public static void setCurrUser(String currUser) {
        CentralProcess.currUser = currUser;
    }

    public static ArrayList<String> getUserList(){
        return userList;
    }

}
