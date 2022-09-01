package com.g16.feyrune.model.action;

import java.util.Random;

import static java.lang.Math.max;

public class Attack {
    private int accuracy;
    private int power;
    private String name;


    public Attack(int accuracy, int power, String name){
        this.accuracy = accuracy;
        this.power = power;
        this.name = name;
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
    public String getName(){
        return name;
    }
}
