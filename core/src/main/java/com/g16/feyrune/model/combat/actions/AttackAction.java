package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.model.combat.AttackHandler;
import com.g16.feyrune.model.combat.creatures.CombatCreature;

public class AttackAction implements ICombatAction {

    @Override
    public boolean executeMove(CombatCreature actor, CombatCreature target) {
        int moveSelection = Random.randomInt(actor.getMoves().size());
        AttackHandler.handleAttack(actor,target,actor.getMoves().get(moveSelection));
        return target.isDead();
    }
}
