package com.g16.feyrune.model.combat.creatures;

import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.model.creature.BaseCreature;


public class PlayerCreature extends CombatCreature {

    /**
     * Constructor for PlayerCreature
     * @param creature The creature to be used in combat
     */
    public PlayerCreature(BaseCreature creature){
        super(creature);
    }

    /**
     * Returns the action of the creature
     * @param target The target of the action
     * @return An action selected by the player.
     */
    @Override
    public ICombatAction selectAction(CombatCreature target) {
        if (selectedAction == null) return null;
        ICombatAction action = selectedAction;
        selectedAction = null;
        return action;
    }

    /**
     * Sets the selected action
     * @param selectedAction The action to be selected
     */
    public void setSelectedAction(ICombatAction selectedAction){
        this.selectedAction = selectedAction;
    }


}
