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
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Model implements IObserver{
    private final StateHandler stateHandler;
    private final Collection<IObserver> observers;
    private final Player player;
    private final OverworldModel overworldModel;
    private CombatModel combatModel;

    /**
     * Constructor for the Model class
     */
    public Model() {
        this("maps/plains1.tmx");
    }

    public Model(String path){
        player = new Player("Player", new Point(0, 0));
        this.overworldModel = new OverworldModel(player, path);
        this.overworldModel.addObserver(this);
        this.observers = new ArrayList<>();
        stateHandler = new StateHandler(ModelState.WORLD);
        this.combatModel = new CombatModel(player, new Encounter(new ICombatable[]{CreatureFactory.createCreature()}));
    }

    /**
     * Advances the model one execution cycle
     */
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

    /**
     * Checks if the player has died
     * @return true if the player has died, false otherwise
     */
    private boolean hasPlayerBlackedOut() {
        return player.creatureIsDead();
    }

    /**
     * Gets a reference to the combatModel
     * @return the combatModel
     */
    public CombatModel getCombatModel(){return combatModel;}

    /**
     * Gets a reference to the overworldModel
     * @return the overworldModel
     */
    public OverworldModel getOverworldModel(){return overworldModel;}
    public StateHandler getStateHandler() {
        return stateHandler;
    }

    /**
     * Gets a reference to the player
     * @return the player
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * Gets a reference to the player's PlayerCreature
     * @return the player's PlayerCreature
     */
    public PlayerCreature getPlayerCreature() {
        return combatModel.getPlayerCreature();
    }

    /**
     * Adds an observer to the model
     * @param observer the observer to be added
     */
    public void registerNewObserver(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Calls observerUpdate on all connected observers
     */
    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.observerUpdate();
        }
    }

    /**
     * Gets a reference to the overworldModel's MovementHandler
     * @return the overworldModel's MovementHandler
     */
    public MovementHandler getMovementHandler() {
        return overworldModel.getMovementHandler();
    }

    /**
     * Changes the current state to the given state
     * @param newState the new state
     */
    public void changeState(ModelState newState){
        stateHandler.changeModelState(newState);
        notifyObservers();
    }

    /**
     * Gets the current state
     * @return the current state
     */
    public ModelState getCurrentModelState(){
        return stateHandler.getModelState();
    }

    /**
     * Starts a new combat encounter if the player has reached an encounter
     */
    @Override
    public void observerUpdate() {
        if (overworldModel.isInEncounter()){
            combatModel = new CombatModel(player, overworldModel.getEncounter());
            changeState(ModelState.COMBAT);
        }
    }
}
