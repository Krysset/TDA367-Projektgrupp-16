package com.g16.feyrune.model.overworld;

import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.overworld.map.MapManager;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;
    private EncounterHandler encounterHandler;
    private ArrayList<IObserver> observerList;
    private MapManager mapManager;


    public OverworldModel(Player player) {
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.encounterHandler = new EncounterHandler();
        this.observerList = new ArrayList<>();
        this.mapManager = new MapManager();
        player.setPosition(mapManager.getStartPosX(), mapManager.getStartPosY());
    }
    public void addObserver(IObserver observer){
        observerList.add(observer);
    }

    public void update(){
        movePlayer();
    }

    public void movePlayer() {
        Point deltaPos = movementHandler.calculateMovement(player.getCoordinates(), mapManager);
        player.move(deltaPos.x, deltaPos.y);
        if (reachedTransporter()) {
            mapManager.useTransporter(player.getCoordinates());
            player.setPosition(mapManager.getStartPosX(), mapManager.getStartPosY());
        } else if (isInEncounter()) {
            movementHandler.resetMovement();
            encounterHandler.createEncounter(mapManager.getTerrainType());
            notifyObservers();
        }
    }

    public boolean reachedTransporter() {
        return mapManager.hasTransporter(player.getCoordinates());
    }
    public boolean isInEncounter(){
        return mapManager.tryEncounter(player.getCoordinates());
    }
    public void removeEncounterFromPlayerTile(){
        mapManager.removeEncounterFromTile(player.getCoordinates());
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
