package com.g16.feyrune.model.combat.creatures;


import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.List;

public abstract class CombatCreature implements ICombatable {
    protected final BaseCreature creature;
    protected ICombatAction selectedAction;

    /**
     * Constructor for CombatCreature
     * @param creature The creature to be used in combat
     */
    public CombatCreature(BaseCreature creature) {
        this.creature = creature;
    }

    /**
     * Returns all abilities of the creature
     * @return All abilities of the creature
     */
    public List<IAbilitable> getMoves() {
        return creature.getMoves();
    }

    /**
     * Returns the speed of the creature
     * @return Speed of the creature
     */
    public int getSpeed() {
        return creature.getSpeed();
    }

    /**
     * Calculates the damage of the creature
     * @param attack the attack to calculate the damage of
     * @return The damage of the creature
     */
    public int calculateAttack(IAbilitable attack) {
        return creature.calculateAttack(attack);
    }

    /**
     * Deals damage to the creature
     * @param damage the amount of damage to take
     */
    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    /**
     * Returns if the creature is dead
     * @return If the creature is dead
     */
    public boolean isDead() {
        return creature.isDead();
    }

    /**
     * Returns the current health of the creature
     * @return Current health of the creature
     */
    public double getHP(){
        return creature.getHP();
    }

    /**
     * Returns the power of the creature
     * @return Power of the creature
     */
    public int getPower(){
        return creature.getPower();
    }

    /**
     * Chooses an action for the creature
     * @param target The target of the action
     * @return The action chosen
     */
    public abstract ICombatAction selectAction(CombatCreature target);

    /**
     * Returns the name of the creature
     * @return Name of the creature
     */
    public String getName(){
        return creature.getName();
    }
}
