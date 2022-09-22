package com.g16.feyrune.interfaces;

import com.g16.feyrune.model.action.BaseAttack;

public interface ICombatSelector {
    ICombatAction selectAction(ICombatCreature actor, ICombatCreature target);

}
