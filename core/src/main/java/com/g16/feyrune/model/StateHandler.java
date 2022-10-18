package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;

/**
 * This class handles the model state
 * the model state is what decides which controller and view that should be active,
 * and which part of the model that should get polled
 */
public class StateHandler {
    private ModelState currentModelState;

    public StateHandler(ModelState currentModelState){
        this.currentModelState = currentModelState;
    }

    public void changeModelState(ModelState modelState){
        currentModelState = modelState;
    }

    public ModelState getModelState(){
        return currentModelState;
    }
}
