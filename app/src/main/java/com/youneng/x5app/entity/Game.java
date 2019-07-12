package com.youneng.x5app.entity;

public class Game {
    private int imgID;
    private String gameName;
    private String gameUrl;

    public Game(int imgID, String gameName, String gameUrl) {
        this.imgID = imgID;
        this.gameName = gameName;
        this.gameUrl = gameUrl;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }
}
