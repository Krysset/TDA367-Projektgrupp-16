package com.g16.feyrune.Util;

public class Random {
    private static final java.util.Random random=new java.util.Random();
    public static int randomInt(int max){
        return random.nextInt(max);
    }
}
