package com.mobproj.guessnow.home_group;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mobproj.guessnow.R;

public class HomeFragment extends Fragment{
    EditText etUniqueCode;
    private Button btn_createroom;
    public static final int LENGTH_SHORT = 0;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container);
        init(view);

        btn_createroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void init(View view) {
        btn_createroom = view.findViewById(R.id.btn_createroom);
    }

}
