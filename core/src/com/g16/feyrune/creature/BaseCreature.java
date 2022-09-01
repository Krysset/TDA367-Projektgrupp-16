package com.g16.feyrune.creature;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private double maxHealth;
    private double health;
    private double attack;
    private double movementSpeed;
    private int evasion;
    private Vector2 position;

    public BaseCreature(double health, double attack, double movementSpeed, Vector2 position, int evasion){
        this.maxHealth = health;
        this.attack = attack;
        this.evasion = evasion;
        this.movementSpeed = movementSpeed;
        this.position = position;
        this.health = this.maxHealth;
    }

    public void spawn(){

    }
    private void die(){

    }
    public double getAttack(){
        return attack;
    }

    public int getEvasion(){
        return evasion;
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
}
