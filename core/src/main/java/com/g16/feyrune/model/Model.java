package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;

import java.util.ArrayList;

public class Model {
    private ModelState currentModelState;
    private ArrayList<IObserver> observers;

    public Model() {
        currentModelState = ModelState.WORLD;
    }

    public ModelState getCurrentModelState() {
        return currentModelState;
    }

    public void registerNewObserver(IObserver observer) {
        observers.add(observer);
    }

    private void updateObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }
}
