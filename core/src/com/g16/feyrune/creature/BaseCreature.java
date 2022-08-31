package com.g16.feyrune.creature;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private double maxHealth;
    private double health;
    private double attack;
    private double movementSpeed;
    private Vector2 position;

    public BaseCreature(double health, double attack, double movementSpeed, Vector2 position){
        this.maxHealth = health;
        this.attack = attack;

        this.movementSpeed = movementSpeed;
        this.position = position;
        this.health = this.maxHealth;
    }

    public void spawn(){

    }
    private void die(){

    }
    public void attack(BaseCreature enemy){

    }

    public void changeHealth(double deltaHealth){
        double newHealth = health + deltaHealth;
        if (newHealth <= 0.0d){
            die();
        }
        health = min(newHealth, maxHealth);
    }
}
