package com.g16.feyrune.model.action;

import com.g16.feyrune.model.combat.actions.IMove;

import static java.lang.Math.max;

public class BaseAttack implements IMove {
    private int accuracy;
    private int power;
    private String name;


    public BaseAttack(int accuracy, int power, String name){
        this.accuracy = accuracy;
        this.power = power;
        this.name = name;
    }
    private double calculateDamage(double attack){
        double trueDamage=max(0, attack*power);
        return trueDamage;
    }
    @Override
    public int getAttackPower(){
        return power;
    }
    @Override
    public int getAttackAccuracy(){
        return accuracy;
    }
    @Override
    public String getAttackName(){
        return name;
    }
}
