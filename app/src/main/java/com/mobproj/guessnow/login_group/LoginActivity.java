package com.mobproj.guessnow.login_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.home_group.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText usernameIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        autoLogin();
        manualLogin();
    }

    private void autoLogin(){

        SharedPreferences sp = getSharedPreferences("localdata", Context.MODE_PRIVATE);
        CentralProcess.setCurrUser(sp.getString("username", ""));

        if(!CentralProcess.getCurrUser().isEmpty()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void manualLogin(){

        loginBtn = findViewById(R.id.loginBtn);
        usernameIn = findViewById(R.id.usernameIn);

        String URL = CentralProcess.getServerURL()+"/joinuser";
        JSONObject userData = new JSONObject();

        loginBtn.setOnClickListener(v -> {

            String currUsername = usernameIn.getText().toString();
            if(currUsername.isEmpty()) return;

            try {
                userData.put("userID", currUsername);
            }catch (JSONException e){
                e.printStackTrace();
            }

            SharedPreferences sp = getSharedPreferences("localdata", Context.MODE_PRIVATE);

            RequestQueue reqQueue = new Volley().newRequestQueue(this);
            JsonObjectRequest objReq = new JsonObjectRequest(Request.Method.POST, URL, userData, response -> {
                String res = new String();
                try {
                    res = response.getString("perms");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("out", res);
                if(res.contentEquals("granted")){
                    CentralProcess.setCurrUser(currUsername);
                    sp.edit().putString("username", CentralProcess.getCurrUser()).commit();
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                }
                else Toast.makeText(this, "Username already taken", Toast.LENGTH_SHORT).show();
            }, error -> {
                error.printStackTrace();
            });

            reqQueue.add(objReq);

        });
    }
}