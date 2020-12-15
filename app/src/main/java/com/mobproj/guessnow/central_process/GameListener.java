package com.mobproj.guessnow.central_process;

import java.util.ArrayList;

public interface GameListener {
    void updateChat(ArrayList<String> nameListUpdate, ArrayList<String> msgListUpdate);
    void updateQst(String currQst);
}
