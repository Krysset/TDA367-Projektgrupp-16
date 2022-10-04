package com.g16.feyrune.interfaces;

import com.g16.feyrune.model.combat.creatures.CombatCreature;

public interface ICombatAction {
    /**
     * Executes the action.
     * @param actor The actor of the action.
     * @param target The target of the action.
     * @return True if the action ends the combat, false otherwise.
     */
    boolean executeMove(CombatCreature actor, CombatCreature target); //TODO: Might need to return Pair<bool,bool> with one of them indicating if the attack order should be rerolled.
}
