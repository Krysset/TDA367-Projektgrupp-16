package com.g16.feyrune.controller;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IInput;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.model.StateHandler;
import com.g16.feyrune.view.View;

public class Controller implements IObserver {
    private Model model;
    private View view;
    IInput combatInputProcessor, worldInputProcessor;
    StateHandler stateHandler;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        combatInputProcessor = new CombatInputProcessor(view.getCombatScene().getCombatInputHandler());
        worldInputProcessor = new WorldInputProcessor(model.getMovementHandler());
        stateHandler = model.getStateHandler();
    }

    @Override
    public void update() {
        ModelState newState = stateHandler.getModelState();
        changeInput(newState);
    }

    public void changeInput(ModelState state){
        switch (state){
            case WORLD:
                worldInputProcessor.setAsInputProcessor();
                break;
            case COMBAT:
                combatInputProcessor.setAsInputProcessor();
                break;
        }
    }
}
