package com.g16.feyrune.model;

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
