package com.mobproj.guessnow;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

public class GameRoom_frg extends Fragment {

    private EditText inputMsg;
    private Button sendBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_room, container, false);

        inputMsg = view.findViewById(R.id.msg_input);
        sendBtn = view.findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(v -> {
            sendBtnAct(v);
        });

        RecyclerView rView = view.findViewById(R.id.chatArea);
        Chat_Adapter chatAdapter = new Chat_Adapter();
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(llm);
        rView.setAdapter(chatAdapter);

        return view;
    }

    public void sendBtnAct(View view){
        String msg = inputMsg.getText().toString();
        String currRoom = CentralProcess.getRoomID()+"-msg";
        String demoRoom = "939262-msg";
        if(TextUtils.isEmpty(msg)) return;
        inputMsg.getText().clear();
        CentralProcess.sendMsg(demoRoom, msg, "Admin");
    }
}
