package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IMove;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class PlayerCreature implements ICombatCreature {
    private ICreature creature;

    public PlayerCreature(ICreature creature) {
        this.creature = creature;
    }

    @Override
    public List<IMove> getMoves() {
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

    @Override
    public ICombatAction selectAction(ICombatCreature actor, ICombatCreature target) {
        throw new NotImplementedException(); //TODO: NOT IMPLEMENTED
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
