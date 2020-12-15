package com.mobproj.guessnow.central_process;

import android.app.Activity;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mobproj.guessnow.game_group.GameInfo_frg;
import com.mobproj.guessnow.game_group.GameRoom_frg;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class CentralProcess{

    private static ScoreboardListener scrListener = null;
    private static GameListener gameListener = null;

    private static String serverURL = "http://192.168.18.163:3000";

    private static Socket socket;
    private static String roomID, lastRoomID = new String();

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

        if(lastRoomID != roomID){
            lastRoomID = roomID;
        }

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
                if(gameListener != null)
                    gameListener.updateChat( userList_Chat, msgList_Chat);
//                GameRoom_frg.dataUpdate(userList_Chat, msgList_Chat);
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
                if(gameListener != null)
                    gameListener.updateQst(currQuestion);
//                GameRoom_frg.qstUpdate(currQuestion);
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

                if(userList.contains(userID)){
                    Integer pos = userList.indexOf(userID);
                    scoreList.set(pos, score);
                }else{
                    userList.add(userID);
                    scoreList.add(score);
                }
                if(scrListener != null)
                    scrListener.updateData(userList, scoreList);

            });
        });

    }

    public static void addGameListener(GameListener listener){
        gameListener = listener;
    }
    public static boolean statusGameListener(){
        if(gameListener == null) return false;
        else return true;
    }

    public static void addScoreListener(ScoreboardListener listener){
        scrListener = listener;
    }
    public static boolean statusScoreListener(){
        if(scrListener == null) return false;
        else return true;
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
        socket.off(roomID+"-msg", args -> {

        });
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

        userList.clear();
        scoreList.clear();
    }

    public static void clearChat() {
        if(!(userList_Chat.isEmpty() && msgList_Chat.isEmpty())){
            userList_Chat.clear();
            msgList_Chat.clear();
            if(gameListener != null)
                gameListener.updateChat(userList_Chat, msgList_Chat);
//            GameRoom_frg.dataUpdate(userList_Chat, msgList_Chat);
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

}
