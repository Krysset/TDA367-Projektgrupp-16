package com.g16.feyrune.model.overworld;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import com.g16.feyrune.model.overworld.map.MapManager;
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;
    private EncounterHandler encounterHandler;
    private ArrayList<IObserver> observerList;
    private MapManager mapManager;
    private boolean activeEncounter;

    public OverworldModel(Player player) {
        activeEncounter = false;
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
        if (deltaPos.x != 0 || deltaPos.y != 0) {
            player.move(deltaPos.x, deltaPos.y);
            if (reachedTransporter()) {
                mapManager.useTransporter(player.getCoordinates());
                player.setPosition(mapManager.getStartPosX(), mapManager.getStartPosY());
            } else if (doesEncounterStart()) {
                movementHandler.resetMovement();
                encounterHandler.createEncounter(mapManager.getTerrainType());
                activeEncounter = true;
                notifyObservers();
            }
        }
    }

    public boolean reachedTransporter() {
        return mapManager.hasTransporter(player.getCoordinates());
    }
    private boolean doesEncounterStart(){
        if(mapManager.tryEncounter(player.getCoordinates())) {
            // about every tenth tile is an encounter
            return Random.randomInt(100) > 90;
        }
        return false;
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

    public MapManager getMapManager(){
        return mapManager;
    }

    public void playerBlackout() {
        mapManager.changeMap("assets/maps/villagehouse.tmx");
        player.setPosition(mapManager.getStartPosX(), mapManager.getStartPosY());
    }

    public boolean isInEncounter() {
        return activeEncounter;
    }

    public void resetIsInEncounter() {
        activeEncounter = false;
    }
}
