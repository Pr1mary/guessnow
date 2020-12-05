package com.mobproj.guessnow.central_process;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mobproj.guessnow.game_group.GameInfo_frg;
import com.mobproj.guessnow.game_group.GameRoom_frg;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class CentralProcess {

    private static String serverURL = "http://192.168.18.163:3000";

    private static Socket socket;
    private static String roomID;

    private static String currUser = new String();

    private static ArrayList<String> userList = new ArrayList<>();
    private static ArrayList<Integer> scoreList = new ArrayList<>();
    private static ArrayList<String> userList_Chat = new ArrayList<>();
    private static ArrayList<String> msgList_Chat = new ArrayList<>();
    private static String currQuestion = new String();

    public static void connectServer(Activity act){

        try {
            socket = IO.socket(serverURL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        socket.connect();
        initName();

        //message process
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
                GameRoom_frg.dataUpdate(userList_Chat, msgList_Chat);
            });
        });

        //question process
        socket.on(roomID+"-qst", args -> {
            act.runOnUiThread(() -> {
                JSONObject msgData = (JSONObject) args[0];
                String question;
                try{
                    question = msgData.getString("QST");
                } catch (JSONException e) {
                    return;
                }
                currQuestion = question;
                GameRoom_frg.qstUpdate(currQuestion);
            });
        });

        //leaderboard process
        socket.on(roomID+"-ld", args -> {
            act.runOnUiThread(() -> {
                JSONObject msgData = (JSONObject) args[0];
                String userID;
                Integer score;
                try{
                    userID = msgData.getString("NAME");
                    score = msgData.getInt("SCORE");
                } catch (JSONException e) {
                    return;
                }
                userList.add(userID);
                scoreList.add(score);
                GameInfo_frg.updateAdapter(userList, scoreList);
            });
        });


    }

    private static void initName(){

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("user", currUser);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        socket.emit(roomID+"-ld", jsonObj);
    }

    public static String getCurrQuestion(){
        return currQuestion;
    }

    public static void disconnectServer(){
        socket.disconnect();
        socket.off(roomID+"-msg");
    }

    public static void sendMsg(String msg){
        JSONObject msgObj = new JSONObject();

        try {
            msgObj.put("user", currUser);
            msgObj.put("msg", msg);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.emit(roomID+"-msg", msgObj);
    }

    public static String getServerURL() { return serverURL; }

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

    public static ArrayList<Integer> getScoreList() {
        return scoreList;
    }

    public static void setUserScore(ArrayList<Integer> userScore) {
        CentralProcess.scoreList = userScore;
    }
}
