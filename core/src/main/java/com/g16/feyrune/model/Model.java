package com.g16.feyrune.model;

import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;
import com.g16.feyrune.model.creature.CreatureFactory;
import com.g16.feyrune.model.overworld.MovementHandler;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.map.MapManager;
import com.g16.feyrune.model.player.Player;
import jdk.internal.icu.text.NormalizerBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Model implements IObserver{
    private final StateHandler stateHandler;
    private final Collection<IObserver> observers;
    private final Player player;
    private final OverworldModel overworldModel;
    private CombatModel combatModel;

    public Model() {
        this("assets/maps/plains1.tmx");
    }

    public Model(String path){
        player = new Player("Player", new Point(0, 0));
        this.overworldModel = new OverworldModel(player, path);
        this.overworldModel.addObserver(this);
        this.observers = new ArrayList<>();
        stateHandler = new StateHandler(ModelState.WORLD);
        this.combatModel = new CombatModel(player, new Encounter(new ICombatable[]{CreatureFactory.createCreature()}));
    }

    public void update() { //TODO: use state pattern
        switch (stateHandler.getModelState()){
            case WORLD:
                overworldModel.update();
                break;
            case COMBAT:
                combatModel.update();
                if (combatModel.getCombatIsOver()) {
                    overworldModel.resetIsInEncounter();
                    stateHandler.changeModelState(ModelState.WORLD);
                    if(hasPlayerBlackedOut()) {
                        overworldModel.playerBlackout();
                        player.healTeam();
                    }
                    notifyObservers();
                }
                break;
        }
    }

    private boolean hasPlayerBlackedOut() {
        return player.creatureIsDead();
    }

    public CombatModel getCombatModel(){return combatModel;}
    public StateHandler getStateHandler() {
        return stateHandler;
    }

    public Player getPlayer(){
        return player;
    }

    public MapManager getMapManager() {
        return overworldModel.getMapManager();
    }

    public PlayerCreature getPlayerCreature() {
        return combatModel.getPlayerCreature();
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
        notifyObservers();
    }
    public ModelState getCurrentModelState(){
        return stateHandler.getModelState();
    }
    @Override
    public void observerUpdate() {
        if (overworldModel.isInEncounter()){
            combatModel = new CombatModel(player, overworldModel.getEncounter());
            changeState(ModelState.COMBAT);
        }
    }
}
