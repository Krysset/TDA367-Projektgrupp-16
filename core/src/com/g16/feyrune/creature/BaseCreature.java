package com.g16.feyrune.creature;

import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private double maxHealth;
    private double health;
    private double damage;
    private double movementSpeed;
    private boolean aggressive;

    private Vector2 position;

    public BaseCreature(double health, double damage, double movementSpeed, boolean aggressive, Vector2 position){
        this.maxHealth = health;
        this.damage = damage;
        this.movementSpeed = movementSpeed;
        this.aggressive = aggressive;
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
