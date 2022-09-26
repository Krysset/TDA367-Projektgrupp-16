package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.model.creature.ICreature;
import com.g16.feyrune.model.combat.actions.ICombatAction;

public interface ICombatCreature extends ICreature {
    ICombatAction selectAction(ICombatCreature actor, ICombatCreature target);

}
