package com.rocketracer.game;

import java.util.HashMap;

public class FBPlaceHolder implements FirebaseInterface{

    @Override
    public Integer createGame() {
        return null;
    }

    @Override
    public void joinGame(Integer gamePin, String name) {

    }
    @Override
    public void setGameScore(int score) { }

    @Override
    public void loadHighScoreList() {}

    @Override
    public void updateHighscoreList(String name, int score) {

    }

    @Override
    public void writeData(HashMap<String, Object> map, String documentPath) {

    }
    @Override
    public void setListener(GameJoinListener gameJoinListener) {
    }

    @Override
    public void setGameListener(GameEventListener listener) {}
    @Override
    public void removeGameListener() {}
}
