package com.g16.feyrune.action;

import java.util.Random;

import static java.lang.Math.max;

public class Attack {
    private int accuracy;
    private int power;

    private Random randomCalc;

    public Attack(int accuracy, int power){
        this.accuracy = accuracy;
        this.power = power;
        randomCalc = new Random();
    }
    private double calculateDamage(double attack){
        double trueDamage=max(0, attack*power);
        return trueDamage;
    }

    public double tryAttack(double attack){
        double trueDamage=calculateDamage(attack);
        int r=randomCalc.nextInt(0,100);
        if ( r < accuracy){
            return trueDamage;
        }
        return 0;
    }
}
