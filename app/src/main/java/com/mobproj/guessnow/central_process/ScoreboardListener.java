package com.mobproj.guessnow.central_process;

import java.util.ArrayList;

public interface ScoreboardListener {
    void updateData(ArrayList<String> nameListUpdate, ArrayList<Integer> scoreListUpdate);
}
