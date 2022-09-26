package com.g16.feyrune.model.combat.ability;

public class BaseAttack implements IAbility {
    private int accuracy;
    private int power;
    private String name;


    public BaseAttack(int accuracy, int power, String name){
        this.accuracy = accuracy;
        this.power = power;
        this.name = name;
    }
    private double calculateDamage(double attack){
        return Math.max(0, attack*power);
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
