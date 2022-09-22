package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.overworld.MovementHandler;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ModelState currentModelState;
    private ArrayList<IObserver> observers;
    private Player player;
    private OverworldModel overworldModel;
    private CombatModel combatModel;

    public Model() {
        currentModelState = ModelState.WORLD;
        player = new Player("Player", new Point(25, 10)); //TODO: Should probably have a method to get the initial player position from the map
        this.overworldModel = new OverworldModel(player);
        this.observers = new ArrayList<>();
    }

    public void update(){
        overworldModel.update();
    }
    public ModelState getCurrentModelState() {
        return currentModelState;
    }

    public Player getPlayer(){
        return player;
    }

    public void registerNewObserver(IObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public MovementHandler getMovementHandler() {
        return overworldModel.getMovementHandler();
    }
}
