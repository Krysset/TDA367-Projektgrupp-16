package com.g16.feyrune.interfaces;

public interface ICombatCreature extends ICreature {
    ICombatAction selectAction(ICombatCreature actor, ICombatCreature target);
}
