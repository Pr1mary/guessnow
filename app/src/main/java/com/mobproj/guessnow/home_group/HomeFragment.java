package com.mobproj.guessnow.home_group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.game_group.GameActivity;
import com.mobproj.guessnow.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    String currRoomID;
    EditText entCode;
    Button btnCreateRoom, btnJoin;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        createRoomProcess(view);
        joinRoomProcess(view);

        return view;
    }

    private void createRoomProcess(View view) {

        btnCreateRoom = view.findViewById(R.id.btn_createroom);
        btnCreateRoom.setOnClickListener(v -> {

            String URL = CentralProcess.getServerURL()+"/reqroom";

            RequestQueue reqQueue = Volley.newRequestQueue(getContext());
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                    Request.Method.GET, URL, null, response -> {
                try {
//                    tempRoomID(response.getString("room"));
                    CentralProcess.setRoomID(response.getString("room"));
                    CentralProcess.clearChat();
                    startActivity(new Intent(getActivity(), GameActivity.class));
                }catch (JSONException e){}
            }, error -> {});
            reqQueue.add(jsonObjReq);

        });
    }

    private void tempRoomID(String roomID){
        currRoomID = roomID;
    }

    private void joinRoomProcess(View view){

        btnJoin = view.findViewById(R.id.joinBtn);
        entCode = view.findViewById(R.id.entCode);

        btnJoin.setOnClickListener(v -> {
            String room = entCode.getText().toString();

            if(TextUtils.isEmpty(room)) return;
            entCode.getText().clear();

            CentralProcess.setRoomID(room);
            CentralProcess.clearChat();
            startActivity(new Intent(getActivity(), GameActivity.class));
        });

    }


}
