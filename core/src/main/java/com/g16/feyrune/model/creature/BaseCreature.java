package com.g16.feyrune.model.creature;


import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IAbilitable;

import java.util.List;

import static java.lang.Math.min;

public class BaseCreature implements ICreature {
    //Stats variables
    private final double maxHealth;
    private double health;
    private int power;
    private int speed;
    private int defense;
    private List<IAbilitable> baseAbilities;
    private boolean isFriend;

    public BaseCreature(double health, int power, int speed, int defense, List<IAbilitable> baseAbilities){
        this.maxHealth = health;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAbilities = baseAbilities;
        this.isFriend = false;
    }


    @Override
    public List<IAbilitable> getMoves() {
        return baseAbilities;
    }

    public int calculateAttack(IAbilitable attack){
        return (int) ((power * ((double) attack.getAttackPower() / 100)));
    }

    public double getHP() {
        return health;
    }

    public int getPower() {
        return power;
    }

    @Override
    public void takeDamage(int damage) {
        health = Math.max(0, health - ((double)damage/defense));
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
