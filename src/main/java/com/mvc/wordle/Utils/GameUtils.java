package com.mvc.wordle.Utils;

import org.springframework.stereotype.Service;

@Service
public class GameUtils {

    private int Max_Tries = 5;

    public void reduceTry() {
        Max_Tries -= 1;
    }

    public int TriesRemaining() {
        return Max_Tries;
    }

    public void resetTries() {
        Max_Tries = 5;
    }
}
