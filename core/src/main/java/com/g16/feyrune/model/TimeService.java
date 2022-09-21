package com.g16.feyrune.model;

import com.badlogic.gdx.utils.TimeUtils;

public class TimeService {

    private static long startTime;
    private static long elapsedTime;

    public static void initialize(){
        startTime = TimeUtils.millis();
    }

    public static long getElapsedTime(){
        return elapsedTime = TimeUtils.timeSinceMillis(startTime);
    }
}
