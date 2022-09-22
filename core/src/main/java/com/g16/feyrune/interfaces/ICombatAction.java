package com.g16.feyrune.interfaces;

public interface ICombatAction {
    /**
     * Executes the action.
     * @param actor The actor of the action.
     * @param target The target of the action.
     * @return True if the action ends the combat, false otherwise.
     */
    boolean execute(ICombatCreature actor, ICombatCreature target); //TODO: Might need to return Pair<bool,bool> with one of them indicateing if the attack order shoud be rerolled.
}
