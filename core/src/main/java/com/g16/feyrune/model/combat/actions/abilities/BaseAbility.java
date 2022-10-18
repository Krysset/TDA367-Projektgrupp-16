package com.g16.feyrune.model.combat.actions.abilities;

import com.g16.feyrune.interfaces.IAbilitable;

import static java.lang.Math.max;

public class BaseAbility implements IAbilitable {
    private int accuracy;
    private int power;
    private String name;

    /**
     * Constructor for BaseAbility
     * @param accuracy Accuracy of the ability
     * @param power Power of the ability
     * @param name Name of the ability
     */
    public BaseAbility(int accuracy, int power, String name){
        this.accuracy = accuracy;
        this.power = power;
        this.name = name;
    }

    /**
     * Returns the power of the ability
     * @return Power of the ability
     */
    @Override
    public int getAttackPower(){
        return power;
    }

    /**
     * Returns the accuracy of the ability
     * @return Accuracy of the ability
     */
    @Override
    public int getAttackAccuracy(){
        return accuracy;
    }

    /**
     * Returns the name of the ability
     * @return Name of the ability
     */
    @Override
    public String getAttackName(){
        return name;
    }
}
