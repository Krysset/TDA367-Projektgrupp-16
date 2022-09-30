package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;

public class FleeAction implements ICombatAction {
    @Override
    public boolean executeMove(ICombatCreature actor, ICombatCreature target) {
        return actor.getSpeed() > target.getSpeed();
    }
}
