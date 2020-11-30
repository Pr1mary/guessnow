package com.mobproj.guessnow;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobproj.guessnow.not_used.User;
import com.mobproj.guessnow.not_used.UserAdapter;

import java.util.ArrayList;


public class GameInfo extends Fragment{

    public View OnCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstance){

        View view =  inflater.inflate(R.layout.fragment_game_info, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ListName);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(ListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

        }

    }

}

