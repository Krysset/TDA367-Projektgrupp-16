package com.g16.feyrune.controller.combat;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;

public interface ICombatController {
    ICombatAction getPlayerActionFromController(ICombatCreature actingCreature);
    boolean hasSelectedAction();
}
