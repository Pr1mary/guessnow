package com.mobproj.guessnow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button btn_createroom;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
        btn_createroom = (Button) findViewById(R.id.btn_createroom);
        btn_createroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open

            }
        });



    }
    public void ->Masukin nama activity di HomeFragment(){

    }
}
