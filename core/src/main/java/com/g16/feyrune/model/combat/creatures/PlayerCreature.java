package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.IAbility;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;

import java.util.List;

public class PlayerCreature implements ICombatCreature {
    private final ICreature creature;
    private ICombatAction selectedAction;

    public PlayerCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public List<IAbility> getMoves() {
        return creature.getMoves();
    }


    @Override
    public double getHP() {
        return creature.getHP();
    }

    @Override
    public int getSpeed() {
        return creature.getSpeed();
    }
    public int getDefense() {
        return creature.getDefense();
    }

    @Override
    public ICombatAction selectAction(ICombatCreature target) {
        if (selectedAction == null) return null;
        ICombatAction action = selectedAction;
        selectedAction = null;
        return action;
    }

    @Override
    public int getPower() {
        return creature.getPower();
    }

    @Override
    public void takeDamage(int damage) {
        creature.takeDamage(damage);
    }

    @Override
    public boolean isDead() {
        return creature.isDead();
    }

    public void setSelectedAction(ICombatAction selectedAction) {
        this.selectedAction = selectedAction;
    }

}
