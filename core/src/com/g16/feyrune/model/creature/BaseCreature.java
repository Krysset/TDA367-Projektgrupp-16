package com.g16.feyrune.model.creature;

import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.model.action.Attack;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private double maxHealth;
    private double health;
    private double baseAttack;
    private double speed;
    private int evasion;
    private Attack[] attacks;

    public BaseCreature(double health, double attack, double movementSpeed, int evasion, Attack[] attacks){
        this.maxHealth = health;
        this.baseAttack = attack;
        this.evasion = evasion;
        this.speed = speed;
        this.health = this.maxHealth;
        this.attacks = attacks;
    }

    private void die(){

    }
    public double getAttack(){
        return baseAttack;
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

    public void damageMonster(double damage){
        setHealth(health-damage);
    }
    public void healMonster(double heal){
        setHealth(heal+health);
    }
}
