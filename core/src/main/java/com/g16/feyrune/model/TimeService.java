package com.g16.feyrune.model;

import com.badlogic.gdx.utils.TimeUtils;

public class TimeService {

    // TODO: Might be an unnecessary klass

    private static long startTime;

    public static void initialize(){
        startTime = TimeUtils.millis();
    }

    public static long getElapsedTime(){
        return TimeUtils.timeSinceMillis(startTime);
    }
}
