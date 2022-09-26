package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.model.combat.creatures.ICombatCreature;

public class fleeAction implements ICombatAction {
    @Override
    public boolean executeMove(ICombatCreature actor, ICombatCreature target) {
        return actor.getSpeed() > target.getSpeed();
    }
}
