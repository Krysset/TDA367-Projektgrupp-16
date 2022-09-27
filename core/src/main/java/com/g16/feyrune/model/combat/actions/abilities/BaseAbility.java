package com.g16.feyrune.model.combat.actions.abilities;

import com.g16.feyrune.interfaces.IAbility;

import static java.lang.Math.max;

public class BaseAbility implements IAbility {
    private int accuracy;
    private int power;
    private String name;


    public BaseAbility(int accuracy, int power, String name){
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
