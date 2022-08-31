package com.g16.feyrune.creature;

import com.badlogic.gdx.math.Vector2;

public class BaseCreature {
    //Stats variables
    private double health;
    private double damage;
    private double movementSpeed;
    private boolean aggressive;

    private Vector2 position;

    public BaseCreature(double health, double damage, double movementSpeed, boolean aggressive, Vector2 position){
        this.health = health;
        this.damage = damage;
        this.movementSpeed = movementSpeed;
        this.aggressive = aggressive;
        this.position = position;
    }

    public void spawn(){

    }
    public void die(){

    }
    public void attack(BaseCreature enemy){

    }
}
