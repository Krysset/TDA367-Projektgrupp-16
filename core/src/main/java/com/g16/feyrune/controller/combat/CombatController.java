package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.combat.ui.ChoiceDialog;
import com.g16.feyrune.controller.IInput;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.view.View;

public class CombatController implements ICombatController, IInput {
    private CombatInputHandler combatInputHandler;
    private CombatInputProcessor inputProcessor;
    private ChoiceDialog choiceDialog;

    public CombatController(View view){
        combatInputHandler = new CombatInputHandler();
        inputProcessor = new CombatInputProcessor(combatInputHandler);
        choiceDialog = new ChoiceDialog(combatInputHandler); //TODO: Add connection for the batch to controller
    }

    @Override
    public void setAsInputProcessor() {
        inputProcessor.setAsInputProcessor();
    }

    @Override
    public ICombatAction getPlayerActionFromController() {
        return null;
    }
}
