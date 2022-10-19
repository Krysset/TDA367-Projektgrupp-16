package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.AttackHandler;


public class AttackAction implements ICombatAction {

    /**
     * Executes the attack action
     * @param actor The actor of the action.
     * @param target The target of the action.
     * @return If the attacked creature died.
     */
    @Override
    public boolean executeMove(ICombatable actor, ICombatable target) {
        int moveSelection = Random.randomInt(actor.getMoves().size());
        AttackHandler.handleAttack(actor,target,actor.getMoves().get(moveSelection));
        return target.isDead();
    }
}
