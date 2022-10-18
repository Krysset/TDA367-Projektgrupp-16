package com.g16.feyrune.model;

import com.badlogic.gdx.utils.TimeUtils;

public class TimeService {
    /**
     * This class is a static class for getting the elapsed time since start of program.
     */
    private static long startTime;

    public static void initialize(){
        startTime = TimeUtils.millis();
    }

    public static long getElapsedTime(){
        return TimeUtils.timeSinceMillis(startTime);
    }
}
