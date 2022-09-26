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
                model.setAsInputProcessor();
                break;
            case COMBAT:
                view.setAsInputProcessor();
                break;
        }
    }
}
