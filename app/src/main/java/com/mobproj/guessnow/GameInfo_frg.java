package com.mobproj.guessnow;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameInfo_frg extends Fragment {

    TextView roominfo;

    static LB_Adapter lbAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        roominfo = view.findViewById(R.id.RoomID);
        roominfo.setText("Room: "+CentralProcess.getRoomID());

        RecyclerView rView = view.findViewById(R.id.LeaderBoard);
        lbAdapter = new LB_Adapter();
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rView.setHasFixedSize(true);
        rView.setLayoutManager(llm);
        rView.setAdapter(lbAdapter);

        return view;
    }

    public static void updateAdapter(ArrayList<String> updatedData){
        lbAdapter.updateData(updatedData);
    }

}
