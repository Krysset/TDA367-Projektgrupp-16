package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ModelState currentModelState;
    private ArrayList<IObserver> observers;

    public Model() {
        currentModelState = ModelState.WORLD;
        Player player = new Player("Player", new Point(0, 0)); // Should probably have a method to get the initial player position from the map
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
