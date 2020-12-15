package com.mobproj.guessnow.game_group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.R;
import com.mobproj.guessnow.central_process.ScoreboardListener;

import java.util.ArrayList;

public class GameInfo_frg extends Fragment implements ScoreboardListener {

    TextView roominfo;

    LB_Adapter lbAdapter = new LB_Adapter();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        roominfo = view.findViewById(R.id.RoomID);
        roominfo.setText("Room: "+ CentralProcess.getRoomID());

        CentralProcess.addScoreListener(this);
        updateData(CentralProcess.getUserList(), CentralProcess.getScoreList());

        RecyclerView rView = view.findViewById(R.id.LeaderBoard);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(llm);
        rView.setAdapter(lbAdapter);

        return view;

    }

    @Override
    public void updateData(ArrayList<String> nameListUpdate, ArrayList<Integer> scoreListUpdate) {
        lbAdapter.updateData(nameListUpdate, scoreListUpdate);
    }
}
