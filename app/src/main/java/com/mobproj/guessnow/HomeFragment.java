package com.mobproj.guessnow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment{
    private Button btn_createroom;
    public static final int LENGTH_SHORT;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    { View view = inflater.inflate(R.layout.fragment_home, container);
    init(view);
    btn_createroom = view.findViewById(R.id.btn_createroom);
    btn_createroom.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btn_createroom(getActivity(),"", btn_createroom.LENGTH_SHORT).show();


        }
    });

        return view;

    }
    private void init(View view){
        btn_createroom = view.findViewById(R.id.btn_createroom);
    }
}
