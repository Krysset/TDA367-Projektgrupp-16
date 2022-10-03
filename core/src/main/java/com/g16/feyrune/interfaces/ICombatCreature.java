package com.g16.feyrune.interfaces;

public interface ICombatCreature extends ICreature { //TODO: mayby Icontrollabe??
    ICombatAction selectAction(ICombatCreature target);

}
