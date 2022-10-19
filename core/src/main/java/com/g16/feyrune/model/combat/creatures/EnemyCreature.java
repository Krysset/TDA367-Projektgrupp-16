package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.*;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import com.g16.feyrune.model.combat.actions.AttackAction;
import com.g16.feyrune.model.creature.BaseCreature;


import java.util.List;

public class EnemyCreature extends CombatCreature {
    /**
     * Constructor for EnemyCreature
     * @param creature The creature to be used in combat
     */
    public EnemyCreature(BaseCreature creature) {
        super(creature);
    }

    /**
     * Returns the action of the creature
     * @param target The target of the action
     * @return A randomly chosen action.
     */
    @Override
    public ICombatAction selectAction(CombatCreature target) {
        return new AttackAction();
    }



}
