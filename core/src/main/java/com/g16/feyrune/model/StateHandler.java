package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;

/**
 * This class handles the model state
 * the model state is what decides which controller and view that should be active,
 * and which part of the model that should get polled
 */
public class StateHandler {
    private ModelState currentModelState;

    /**
     * Constructor for the StateHandler class
     * @param currentModelState the current model state
     */
    public StateHandler(ModelState currentModelState){
        this.currentModelState = currentModelState;
    }

    /**
     * Changes the current model state to the given model state
     * @param modelState the new model state
     */
    public void changeModelState(ModelState modelState){
        currentModelState = modelState;
    }

    /**
     * Gets the current model state
     * @return the current model state
     */
    public ModelState getModelState(){
        return currentModelState;
    }
}
