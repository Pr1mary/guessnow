package com.mobproj.guessnow.game_group;

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

import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.central_process.GameListener;

import java.util.ArrayList;

public class GameRoom_frg extends Fragment implements GameListener {

    private EditText inputMsg;
    private Button sendBtn;
    private TextView qstArea;

    private Chat_Adapter chatAdapter;
    private RecyclerView chatView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_room, container, false);

        chatView = view.findViewById(R.id.chatArea);
        chatAdapter = new Chat_Adapter();

        qstArea = view.findViewById(R.id.qstArea);
        inputMsg = view.findViewById(R.id.msg_input);
        sendBtn = view.findViewById(R.id.sendBtn);

        CentralProcess.addGameListener(this);

        sendBtn.setOnClickListener(v -> sendBtnAct(v));

        qstArea.setText(CentralProcess.getCurrQuestion());

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        chatView.setHasFixedSize(true);
        chatView.setLayoutManager(llm);
        chatView.setAdapter(chatAdapter);

        return view;
    }

    public void sendBtnAct(View view){
        String msg = inputMsg.getText().toString();
        if(TextUtils.isEmpty(msg)) return;
        inputMsg.getText().clear();
        CentralProcess.sendMsg(msg);
    }

    @Override
    public void updateQst(String currQst) {
        qstArea.setText(currQst);
    }

    @Override
    public void updateChat(ArrayList<String> nameListUpdate, ArrayList<String> msgListUpdate) {
        chatAdapter.updateChat(nameListUpdate, msgListUpdate);
        chatView.smoothScrollToPosition(chatAdapter.getItemCount());
    }
}
