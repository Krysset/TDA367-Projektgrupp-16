package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IAbilitable;

import java.util.List;

public class PlayerCreature implements ICombatCreature {
    private final ICreature creature;
    private ICombatAction selectedAction;

    public PlayerCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public List<IAbilitable> getMoves() {
        return creature.getMoves();
    }




    @Override
    public int getSpeed() {
        return creature.getSpeed();
    }


    @Override
    public ICombatAction selectAction(ICombatCreature target) {
        if (selectedAction == null) return null;
        ICombatAction action = selectedAction;
        selectedAction = null;
        return action;
    }
    @Override
    public int attack(IAbilitable attack) {
        return creature.attack(attack);
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
