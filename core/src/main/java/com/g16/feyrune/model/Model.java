package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.overworld.MovementHandler;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class Model implements IObserver {
    private StateHandler stateHandler;
    private ArrayList<IObserver> observers;
    private Player player;
    private OverworldModel overworldModel;
    private CombatModel combatModel;

    public Model() {
        player = new Player("Player", new Point(20, 5)); //TODO: Should probably have a method to get the initial player position from the map
        this.overworldModel = new OverworldModel(player);
        this.overworldModel.addObserver(this);
        this.observers = new ArrayList<>();
        stateHandler = new StateHandler(ModelState.WORLD);
    }

    public void update() {
        overworldModel.update();
        if(overworldModel.isInEncounter()){
            changeState(ModelState.COMBAT);
            notifyObservers();
        }
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }

    public Player getPlayer(){
        return player;
    }

    public void registerNewObserver(IObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.observerUpdate();
        }
    }

    public MovementHandler getMovementHandler() {
        return overworldModel.getMovementHandler();
    }

    public void changeState(ModelState newState){
        stateHandler.changeModelState(newState);
    }
    public ModelState getCurrentModelState(){
        return stateHandler.getModelState();
    }
    @Override
    public void observerUpdate() {
        if (overworldModel.isInEncounter()){
            changeState(ModelState.COMBAT);
            overworldModel.removeEncounterFromPlayerTile();
        }
        for(IObserver observer : observers){
            observer.observerUpdate();
        }
    }
}
