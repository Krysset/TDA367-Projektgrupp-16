package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.creatures.CombatCreature;

public class FleeAction implements ICombatAction {
    /**
     * Executes an action
     * @param actor The actor of the action.
     * @param target The target of the action.
     * @return if you successfully fled
     */
    @Override
    public boolean executeMove(ICombatable actor, ICombatable target) {
        return actor.getSpeed() > target.getSpeed();
    }
}
