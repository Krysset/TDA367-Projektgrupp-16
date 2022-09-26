package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.model.combat.creatures.ICombatCreature;
import com.g16.feyrune.model.combat.AttackHandler;

public class attackAction implements ICombatAction {

    @Override
    public boolean executeMove(ICombatCreature actor, ICombatCreature target) {
        int moveSelection = Random.randomInt(actor.getMoves().size());
        AttackHandler.handleAttack(actor,target,actor.getMoves().get(moveSelection));
        return false;
    }
}
