package com.mobproj.guessnow.game_group;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import com.mobproj.guessnow.central_process.CentralProcess;
import com.mobproj.guessnow.R;

public class GameActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        CentralProcess.connectServer(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        frameLayout = findViewById(R.id.layoutContainer);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Game Room"));
        tabLayout.addTab(tabLayout.newTab().setText("Game Info"));

        frgTransaction(fragmentManager, new GameRoom_frg());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        frgTransaction(fragmentManager, new GameRoom_frg());
                        break;
                    case 1:
                        frgTransaction(fragmentManager, new GameInfo_frg());
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CentralProcess.disconnectServer();
    }

    private void frgTransaction(FragmentManager frgManager, Fragment frg){
        Fragment fragment = frg;
        FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
        fragmentTransaction.replace(R.id.layoutContainer,fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}