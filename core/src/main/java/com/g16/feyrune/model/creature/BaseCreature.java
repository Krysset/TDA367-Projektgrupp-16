package com.g16.feyrune.model.creature;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IAbility;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class BaseCreature implements ICreature {
    //Stats variables
    private final double maxHealth;
    private double health;
    private int power;
    private int speed;
    private int evasion;
    private BaseAbility[] baseAbilities;
    private boolean isFriend;

    public BaseCreature(double health, int power, int speed, int evasion, BaseAbility[] baseAbilities){
        this.maxHealth = health;
        this.power = power;
        this.evasion = evasion;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAbilities = baseAbilities;
        this.isFriend = false;
    }

    private void die(){

    }

    private void setHealth(double newHealth){
        if (newHealth <= 0.0d){
            die();
        }
        health = min(newHealth, maxHealth);
    }

    public void damageMonster(double damage){
        setHealth(health-damage);
    }
    public void healMonster(double heal){
        setHealth(heal+health);
    }

    @Override
    public List<IAbility> getMoves() {
        ArrayList<IAbility> moves = new ArrayList<>();
        IAbility baseAbility = new BaseAbility(speed, power,"TEMP"); //TODO: THIS IS TEMPORARY, PLZ FIX LATER :)
        moves.add(baseAbility);
        return moves;
    }

    @Override
    public double getHP() {
        return health;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
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
