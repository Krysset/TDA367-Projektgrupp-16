package com.g16.feyrune.model.overworld;

import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;
    private EncounterHandler encounterHandler;
    private Map map;
    private ArrayList<IObserver> observerList;


    public OverworldModel(Player player) {
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.map = Map.getGlobalMap();
        this.encounterHandler = new EncounterHandler();
        this.observerList = new ArrayList<>();
        player.setPosition(map.getStartPosX(), map.getStartPosY());
    }
    public void addObserver(IObserver observer){
        observerList.add(observer);
    }

    public void update(){
        movePlayer();
    }

    public void movePlayer() {
        Point deltaPos = movementHandler.calculateMovement(player.getCoordinates(), map);
        player.move(deltaPos.x, deltaPos.y);
        if (isInEncounter()) {
            movementHandler.resetMovement();
            encounterHandler.createEncounter(map.getTerrainType());
            notifyObservers();
        }
    }

    public boolean isInEncounter(){
        return map.tryEncounter(player.getCoordinates());
    }
    public void removeEncounterFromPlayerTile(){
        map.removeEncounterFromTile(player.getCoordinates());
    }


    public MovementHandler getMovementHandler() {
        return movementHandler;
    }

    private void notifyObservers(){
        for (IObserver observer : observerList) {
            observer.observerUpdate();
        }
    }
    public Encounter getEncounter(){
        return encounterHandler.createEncounter("dungeon");
    }
}
