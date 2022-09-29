package com.g16.feyrune.controller.combat;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.g16.feyrune.controller.combat.ui.ChoiceDialog;
import com.g16.feyrune.controller.IInput;
import com.g16.feyrune.controller.enums.Selection;
import com.g16.feyrune.interfaces.ICombatAction;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.model.combat.actions.attackAction;
import com.g16.feyrune.view.View;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CombatController implements ICombatController, IInput {
    private CombatInputHandler combatInputHandler;
    private CombatInputProcessor inputProcessor;
    private ChoiceDialog choiceDialog;
    // Takes whole model so that logic can be written to get new player creature each time
    // the player's creature changes. Could be streamlined later.
    private Model model;

    private boolean hasSelectedAction;

    public CombatController(Model model){
        this.model = model;
        combatInputHandler = new CombatInputHandler();
        inputProcessor = new CombatInputProcessor(combatInputHandler);
        choiceDialog = new ChoiceDialog(combatInputHandler); //TODO: Add connection for the batch to controller
        model.getPlayerCreature().registerCombatController(this);
    }

    // This is patchwork code to make it work.
    public void render(Batch batch) {
        choiceDialog.render(batch);
    }

    @Override
    public void setAsInputProcessor() {
        inputProcessor.setAsInputProcessor();
    }

    @Override
    public ICombatAction getPlayerActionFromController(ICombatCreature actingCreature) {
        Selection selection = combatInputHandler.getChosenAction();
        switch (selection) {
            case FIRST:
                return new attackAction();
            default:
                return null;
        }
    }

    @Override
    public boolean hasSelectedAction(){
        return combatInputHandler.hasSelectedAction();
    }

    private void setListenToCurrentPlayerCreature() {
        model.getPlayerCreature().registerCombatController(this);
    }
}
