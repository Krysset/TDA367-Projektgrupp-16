package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;

public class fleeAction implements ICombatAction {
    @Override
    public boolean executeMove(ICombatCreature actor, ICombatCreature target) {
        if (actor.getSpeed()> target.getSpeed())
            return true;
        else
            return false;
    }
}
