package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.model.combat.AttackHandler;

public class attackAction implements ICombatAction {

    @Override
    public boolean executeMove(ICombatCreature actor, ICombatCreature target) {
        int moveSelection = Random.random.nextInt(actor.getMoves().size());
        AttackHandler.handleAttack(actor,target,actor.getMoves().get(moveSelection));
        return false;
    }
}
