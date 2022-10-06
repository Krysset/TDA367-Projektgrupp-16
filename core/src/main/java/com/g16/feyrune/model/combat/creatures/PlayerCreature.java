package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.model.creature.BaseCreature;


public class PlayerCreature extends CombatCreature {

    public PlayerCreature(BaseCreature creature){
        super(creature);
    }
    @Override
    public ICombatAction selectAction(CombatCreature target) {
        if (selectedAction == null) return null;
        ICombatAction action = selectedAction;
        selectedAction = null;
        return action;
    }
    public void setSelectedAction(ICombatAction selectedAction){
        this.selectedAction = selectedAction;
    }


}
