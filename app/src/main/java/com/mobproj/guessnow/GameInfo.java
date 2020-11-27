package com.mobproj.guessnow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GameInfo extends Fragment {



    public GameInfo() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_game_info, container, false);
    }


}