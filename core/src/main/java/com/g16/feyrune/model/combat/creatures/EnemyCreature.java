package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.*;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import com.g16.feyrune.model.combat.actions.AttackAction;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.List;

public class EnemyCreature extends CombatCreature {
    private BaseCreature creature;

    public EnemyCreature(BaseCreature creature) {
        super(creature);
    }

    @Override
    public ICombatAction selectAction(CombatCreature target) {
        return new AttackAction();
    }



}
