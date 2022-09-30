package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.controller.combat.ICombatController;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IAbility;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class PlayerCreature implements ICombatCreature {
    private final ICreature creature;
    private ICombatController combatController;

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
        // There has to be a better way to do this,
        // but currently I just want to get it working.
        if(combatController.hasSelectedAction()) {
            return combatController.getPlayerActionFromController(this);
        }
        return null;
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

    public void registerCombatController(ICombatController combatController) {
        this.combatController = combatController;
    }

}
