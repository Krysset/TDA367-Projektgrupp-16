package com.g16.feyrune.action;

import java.util.Random;

import static java.lang.Math.max;

public class Attack {
    private int accuracy;
    private int power;


    public Attack(int accuracy, int power){
        this.accuracy = accuracy;
        this.power = power;
    }
    private double calculateDamage(double attack){
        double trueDamage=max(0, attack*power);
        return trueDamage;
    }

    public int getPower(){
        return power;
    }
    public int getAccuracy(){
        return accuracy;
    }
}
