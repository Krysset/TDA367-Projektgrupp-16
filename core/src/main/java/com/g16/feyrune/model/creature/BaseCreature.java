package com.g16.feyrune.model.creature;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.actions.IMove;

import java.util.ArrayList;
import java.util.List;

public class BaseCreature implements ICreature {
    private final double maxHealth;
    private double health;
    private int power;
    private int speed;
    private ArrayList<IMove> moves;
    private boolean dead = false;

    public BaseCreature(double health, int power, int speed, ArrayList<IMove> moves){
        this.maxHealth = health;
        this.power = power;
        this.speed = speed;
        this.health = this.maxHealth;
        this.moves = moves;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
    @Override
    public List<IMove> getMoves() {
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
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        double newHealth = Math.max(health - damage, 0);
        if (newHealth == 0.0){
            die();
        }
        health = newHealth;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    private void die() {
        this.dead = true;
    }
}
