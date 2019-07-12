package com.avy.haobai;

import com.light.play.api.LightPlay;
import com.light.play.api.OnPlayErrorListener;
import com.light.play.api.OnPlayPreparedListener;
import com.light.play.api.OnPlayStatusListener;

public class LightPlayManager {
    private static LightPlayManager instance;
    private LightPlay lightPlay;
    public LightPlayManager(){
        lightPlay = new LightPlay();
    }

    public static LightPlayManager getInstance(){
        if (instance == null){
            instance = new LightPlayManager();
        }
        return instance;
    }

    public LightPlay getLightPlay(){
        return lightPlay;
    }


    public void setOnErrorListener(OnPlayErrorListener listener){
        lightPlay.setOnErrorListener(listener);
    }

    public void setOnStatusListener(OnPlayStatusListener listener){
        lightPlay.setOnStatusListener(listener);
    }

    public void setOnPrepareListener(OnPlayPreparedListener listener){
        lightPlay.setOnPreparedListener(listener);
    }
}
