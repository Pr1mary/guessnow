package com.mobproj.guessnow.home_group;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.login_group.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserFragment extends Fragment {

    TextView usernameShow;
    Button logoutBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user,container,false);

        usernameShow = view.findViewById(R.id.userDisplay);
        usernameShow.setText("Hello, "+CentralProcess.getCurrUser()+"!");

        logoutProcess(view);

        return view;

    }

    private void logoutProcess(View view){

        logoutBtn = view.findViewById(R.id.logoutBtn);

        String URL = CentralProcess.getServerURL()+"/quituser";
        JSONObject userData = new JSONObject();

        logoutBtn.setOnClickListener(v -> {

            String currUsername = CentralProcess.getCurrUser();

            try {
                userData.put("userID", currUsername);
            }catch (JSONException e){
                e.printStackTrace();
            }
            SharedPreferences sp = getContext().getSharedPreferences("localdata", Context.MODE_PRIVATE);
            RequestQueue reqQueue = new Volley().newRequestQueue(getContext());
            JsonObjectRequest objReq = new JsonObjectRequest(Request.Method.POST, URL, userData, response -> {
                String res = new String();
                try {
                    res = response.getString("status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("quit", res);
                if(res.contentEquals("user quit")){
                    CentralProcess.setCurrUser("");
                    sp.edit().putString("username", CentralProcess.getCurrUser()).commit();
                    getActivity().finish();
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                else Toast.makeText(getContext(), "Logout failed", Toast.LENGTH_SHORT).show();
            }, error -> {
                error.printStackTrace();
            });

            reqQueue.add(objReq);

        });
    }

}
