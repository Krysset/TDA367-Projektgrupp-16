package com.g16.feyrune.model.creature;


import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.interfaces.IAbilitable;

import java.util.List;

import static java.lang.Math.min;

public class BaseCreature implements ICombatable {
    //Stats variables
    private final double maxHealth;
    private double health;
    private int power;
    private int speed;
    private int defense;
    private List<IAbilitable> baseAbilities;
    private boolean isFriend;
    private String name;

    /**
     * Constructor for BaseCreature
     * @param name Name of the creature
     * @param health Health of the creature
     * @param power Power of the creature
     * @param speed Speed of the creature
     * @param defense Defense of the creature
     * @param baseAbilities List of abilities of the creature
     */
    public BaseCreature(String name, double health, int power, int speed, int defense, List<IAbilitable> baseAbilities){
        this.maxHealth = health;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.health = this.maxHealth;
        this.baseAbilities = baseAbilities;
        this.isFriend = false;
        this.name = name;
    }

    /**
     * Returns a list of the abilities of the creature
     * @return List of the abilities of the creature
     */
    @Override
    public List<IAbilitable> getMoves() {
        return baseAbilities;
    }

    /**
     * Calculates how much damage the attack will do
     * @param attack the attack to calculate the damage of
     * @return The damage of the attack
     */
    public int calculateAttack(IAbilitable attack){
        return (int) ((power * ((double) attack.getAttackPower() / 100)));
    }

    /**
     * Returns the current health of the creature
     * @return Current health of the creature
     */
    public double getHP() {
        return health;
    }

    /**
     * Returns the power of the creature
     * @return Power of the creature
     */
    public int getPower() {
        return power;
    }

    /**
     * Hits the creature really hard
     * @param damage the amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        health = Math.max(0, health - ((double)damage/defense));
    }

    /**
     * Returns if the creature is dead
     * @return If the creature is dead
     */
    @Override
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Returns the speed of the creature
     * @return Speed of the creature
     */
    @Override
    public int getSpeed() {
        return speed;
    }

    /**
     * Returns the name of the creature
     * @return Name of the creature
     */
    public String getName() {
        return name;
    }
}
