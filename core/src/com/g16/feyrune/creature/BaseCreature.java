package com.g16.feyrune.creature;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import static java.lang.Math.min;

public class BaseCreature {
    //Stats variables
    private double maxHealth;
    private double health;
    private double attack;
    private double movementSpeed;
    private Vector2 position;
    private int evasion;
    private Random randomCalc;


    public BaseCreature(double health, double attack, double movementSpeed, Vector2 position, int evasion){
        this.maxHealth = health;
        this.attack = attack;
        this.movementSpeed = movementSpeed;
        this.position = position;
        this.health = this.maxHealth;
        this.evasion = evasion;
        randomCalc = new Random();
    }

    public void spawn(){

    }
    private void die(){

    }
    public void attack(BaseCreature enemy){

    }

    private void changeHealth(double healthChange){
        double newHealth = health + healthChange;
        if (newHealth <= 0.0d){
            die();
        }
        health = min(newHealth, maxHealth);
    }

    private boolean evade(){
        int tryEvade = randomCalc.nextInt(0,100);
        return (tryEvade < evasion)? true : false;
    }
    public void hurt(double damage){
        if(!evade()){
            changeHealth(-damage);
        }
    }

    /**
     * Adds health to the creature
     * @param: Amount to heal (though maxHealth is max total)
     */
    public void heal(double addedHealth){
        changeHealth(addedHealth);
    }
}
