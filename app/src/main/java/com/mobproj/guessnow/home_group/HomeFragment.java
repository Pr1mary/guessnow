package com.mobproj.guessnow.home_group;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobproj.guessnow.RoomObj;
import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.game_group.GameActivity;
import com.mobproj.guessnow.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class HomeFragment extends Fragment{

    EditText entCode;
    Button btnCreateRoom, btnJoin;
    public static final int LENGTH_SHORT = 0;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CentralProcess.getServerURL())
                .build();


        createRoomProcess(view);
        joinRoomProcess(view);

        return view;
    }

    @GET("/reqroom")
    public void login(){}


    private void createRoomProcess(View view) {

        btnCreateRoom = view.findViewById(R.id.btn_createroom);
        btnCreateRoom.setOnClickListener(v -> {
        });
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
