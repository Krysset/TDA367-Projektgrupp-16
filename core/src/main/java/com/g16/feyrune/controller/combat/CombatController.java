package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.combat.ui.ChoiceDialog;
import com.g16.feyrune.controller.IInput;
import com.g16.feyrune.interfaces.ICombatAction;

public class CombatController implements ICombatController, IInput {
    private CombatInputHandler combatInputHandler;
    private CombatInputProcessor inputProcessor;
    private ChoiceDialog choiceDialog;

    @Override
    public void setAsInputProcessor() {
        inputProcessor.setAsInputProcessor();
    }

    @Override
    public ICombatAction getPlayerActionFromController() {
        return null;
    }
}
