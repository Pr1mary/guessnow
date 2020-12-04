package com.mobproj.guessnow.login_group;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.home_group.MainActivity;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText usernameIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(!CentralProcess.getCurrUser().isEmpty()){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {
            loginProcess();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });


    }

    private void loginProcess(){
        usernameIn = findViewById(R.id.usernameIn);
        String currUsername = usernameIn.getText().toString();
        if(currUsername.isEmpty()) return;
        CentralProcess.setCurrUser(currUsername);
    }

}