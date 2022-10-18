package com.g16.feyrune.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.g16.feyrune.controller.combat.CombatController;
import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.model.StateHandler;
import com.g16.feyrune.view.View;

public class Controller implements IObserver {
    private Model model;
    private View view;
    IInput combatController, worldInputProcessor;
    StateHandler stateHandler;

    /**
     * Constructor for the controller
     * @param model the model to control
     * @param view the view
     */
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        // TODO: Fix line below
        combatController = new CombatController(model);
        worldInputProcessor = new WorldInputProcessor(model.getMovementHandler());
        stateHandler = model.getStateHandler();
        model.registerNewObserver(this);

        observerUpdate();
    }

    /**
     * Updates the modelState and changes inputProcessor accordingly
     */
    @Override
    public void observerUpdate() {
        ModelState newState = stateHandler.getModelState();
        changeInput(newState);
    }

    /**
     * Renders the controller
     * @param batch the batch to render to
     */
    public void render(Batch batch) {
        batch.begin();
        if (model.getCurrentModelState() == ModelState.COMBAT)
            ((CombatController) combatController).render(batch);
        batch.end();
    }

    /**
     * Changes the inputProcessor depending on the modelState
     * @param state the new modelState
     */
    public void changeInput(ModelState state){
        switch (state){
            case WORLD:
                worldInputProcessor.setAsInputProcessor();
                break;
            case COMBAT:
                combatController = new CombatController(model);
                combatController.setAsInputProcessor();
                break;
        }
    }
}
