package com.g16.feyrune.model.creature;

import com.g16.feyrune.model.action.BaseAttack;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private final double maxHealth;
    private double health;
    private double strength;
    private double speed;
    private int evasion;
    private BaseAttack[] baseAttacks;
    private boolean isFriend;

    public BaseCreature(double health, double attack, double speed, int evasion, BaseAttack[] baseAttacks){
        this.maxHealth = health;
        this.strength = attack;
        this.evasion = evasion;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAttacks = baseAttacks;
        this.isFriend = false;
    }

    private void die(){

    }
    public BaseAttack[] getAttacks(){
        return baseAttacks;
    }
    public double getStrength(){
        return strength;
    }

    public int getEvasion(){
        return evasion;
    }

    public double getSpeed() {return speed; }

    private void setHealth(double newHealth){
        if (newHealth <= 0.0d){
            die();
        }
        health = min(newHealth, maxHealth);
    }
    public void setFriend(boolean friend){
        this.isFriend = friend;
    }
    public boolean isFriend(){
        return isFriend;
    }

    public void damageMonster(double damage){
        setHealth(health-damage);
    }
    public void healMonster(double heal){
        setHealth(heal+health);
    }
}
