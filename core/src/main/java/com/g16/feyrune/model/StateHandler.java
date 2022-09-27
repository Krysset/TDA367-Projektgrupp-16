package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;

public class StateHandler {
    private ModelState currentModelState;

    public StateHandler(ModelState currentModelState){
        this.currentModelState = currentModelState;
    }

    public void changeModelState(ModelState modelState){
        currentModelState = modelState;
    }

    public ModelState getModelState(){
        return ModelState.COMBAT;
//        return currentModelState;
    }
}
