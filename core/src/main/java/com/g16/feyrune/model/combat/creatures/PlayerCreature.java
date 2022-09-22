package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICombatSelector;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.action.BaseAttack;
import com.g16.feyrune.model.combat.actions.IMove;

import java.util.List;

public class PlayerCreature implements ICombatCreature {
    private ICreature creature;

    public PlayerCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public List<IMove> getMoves() {
        return null;
    }


    @Override
    public double getHP() {
        return 0;
    }

    public int getSpeed() {
        return creature.getSpeed();
    }

    @Override
    public ICombatAction selectAction(ICombatCreature actor, ICombatCreature target) {
        return null;
    }

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public boolean isDead() {
        return false;
    }

}
