package com.g16.feyrune.model.creature;

import com.g16.feyrune.model.combat.ability.IAbility;
import com.g16.feyrune.model.combat.ability.BaseAttack;

import java.util.ArrayList;
import java.util.List;

public class BaseCreature implements ICreature {
    //Stats variables
    private final double maxHealth;
    private double health;
    private int power;
    private int speed;
    private int evasion;
    private BaseAttack[] baseAttacks;

    public BaseCreature(double health, int power, int speed, int evasion, BaseAttack[] baseAttacks){
        this.maxHealth = health;
        this.power = power;
        this.evasion = evasion;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAttacks = baseAttacks;
    }

    private void setHealth(double newHealth){
        health = Math.max(Math.min(0, newHealth), maxHealth);
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
        IAbility baseAttack = new BaseAttack(speed, power,"TEMP"); //TODO: THIS IS TEMPORARY, PLZ FIX LATER :)
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
