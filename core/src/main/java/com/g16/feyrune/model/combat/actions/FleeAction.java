package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.creatures.CombatCreature;

public class FleeAction implements ICombatAction {
    @Override
    public boolean executeMove(ICombatable actor, ICombatable target) {
        return actor.getSpeed() > target.getSpeed();
    }
}
