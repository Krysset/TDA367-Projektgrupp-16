package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;
import com.g16.feyrune.model.creature.CreatureFactory;
import com.g16.feyrune.model.overworld.MovementHandler;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class Model {
    private StateHandler stateHandler;
    private ArrayList<IObserver> observers;
    private Player player;
    private OverworldModel overworldModel;
    private CombatModel combatModel;

    public Model() {
        player = new Player("Player", new Point(20, 5)); //TODO: Should probably have a method to get the initial player position from the map
        this.overworldModel = new OverworldModel(player);
        this.observers = new ArrayList<>();
        stateHandler = new StateHandler(ModelState.COMBAT);
        this.combatModel = new CombatModel(player, new Encounter(new ICreature[]{CreatureFactory.createCreature()}));
    }

    public void update() {
        switch (stateHandler.getModelState()){
            case WORLD:
                overworldModel.update();
                break;
            case COMBAT:
                combatModel.update();
                if (combatModel.getCombatIsOver()) stateHandler.changeModelState(ModelState.WORLD);
                break;
        }
    }

    public StateHandler getStateHandler() {
        return stateHandler;
    }

    public Player getPlayer(){
        return player;
    }

    public PlayerCreature getPlayerCreature() {
        return combatModel.getPlayerCreature();
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

    public void changeState(ModelState newState){
        stateHandler.changeModelState(newState);
    }
    public ModelState getCurrentModelState(){
        return stateHandler.getModelState();
    }
}
