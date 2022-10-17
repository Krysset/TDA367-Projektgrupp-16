package com.g16.feyrune.controller.combat;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.g16.feyrune.controller.IInput;
import com.g16.feyrune.controller.combat.ui.ChoiceDialog;
import com.g16.feyrune.model.Model;

public class CombatController implements IInput {
    private final CombatInputHandler combatInputHandler;
    private final CombatInputProcessor inputProcessor;
    private final ChoiceDialog choiceDialog;
    // Takes whole model so that logic can be written to get new player creature each time
    // the player's creature changes. Could be streamlined later.

    /**
     * Constructor for CombatController
     * @param model the model to be attached to the Combat controller
     */
    public CombatController(Model model){
        combatInputHandler = new CombatInputHandler(model.getPlayerCreature());
        inputProcessor = new CombatInputProcessor(combatInputHandler);
        choiceDialog = new ChoiceDialog(combatInputHandler); //TODO: Add connection for the batch to controller
    }

    // This is patchwork code to make it work.

    /**
     * Updates the combat controller grahically
     * @param batch the batch to render using
     */
    public void render(Batch batch) {
        choiceDialog.render(batch);
    }

    /**
     * Sets CombatController to be the active input processor
     */
    @Override
    public void setAsInputProcessor() {
        inputProcessor.setAsInputProcessor();
    }
}
