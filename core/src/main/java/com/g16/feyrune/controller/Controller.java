package com.g16.feyrune.controller;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IInput;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.Model;

public class Controller implements IObserver {
    private Model model;
    IInput combatInputProcessor, worldInputProcessor;

    public Controller(Model model){
        this.model = model;
        combatInputProcessor = new CombatInputProcessor();
        worldInputProcessor = new WorldInputProcessor(model.getMovementHandler());
    }

    @Override
    public void update() {
        ModelState newState = model.getCurrentModelState();
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
