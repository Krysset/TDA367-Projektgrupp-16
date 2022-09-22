package com.g16.feyrune.model.creature;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IMove;
import com.g16.feyrune.model.action.BaseAttack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class BaseCreature implements ICreature {
    //Stats variables
    private final double maxHealth;
    private double health;
    private int strength;
    private int speed;
    private int evasion;
    private BaseAttack[] baseAttacks;
    private boolean isFriend;

    public BaseCreature(double health, int strength, int speed, int evasion, BaseAttack[] baseAttacks){
        this.maxHealth = health;
        this.strength = strength;
        this.evasion = evasion;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAttacks = baseAttacks;
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
    public List<IMove> getMoves() {
        ArrayList<IMove> moves = new ArrayList<>();
        IMove baseAttack = new BaseAttack(speed,power,"TEMP"); //TODO: THIS IS TEMPORARY, PLZ FIX LATER :)
        moves.add(baseAttack);
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
        int newHealth = Math.max(0, health - damage);
        health = newHealth;
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
