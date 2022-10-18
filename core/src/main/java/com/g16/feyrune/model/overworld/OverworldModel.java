package com.g16.feyrune.model.overworld;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.overworld.map.Map;
import com.g16.feyrune.model.overworld.map.MapParser;
import com.g16.feyrune.model.overworld.map.Transporter;
import com.g16.feyrune.model.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OverworldModel {
    private final Player player;
    private final MovementHandler movementHandler;
    private final EncounterHandler encounterHandler;
    private final Collection<IObserver> observerList;
    private Map map;
    private boolean activeEncounter;
    private List<IMapObserver> mapObservers;

    public OverworldModel(Player player) {
        activeEncounter = false;
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.encounterHandler = new EncounterHandler();
        this.observerList = new ArrayList<>();
        mapObservers = new ArrayList<>();
        changeMap("assets/maps/plains1.tmx");
    }
    public void addObserver(IObserver observer){
        observerList.add(observer);
    }

    public void update(){
        movePlayer();
    }

    public void movePlayer() {
        Point deltaPos = movementHandler.calculateMovement(player.getCoordinates(), map);
        if (deltaPos.x != 0 || deltaPos.y != 0) {
            player.move(deltaPos.x, deltaPos.y);
            if (reachedTransporter()) {
                activateTransporter();
            } else if (doesEncounterStart()) {
                movementHandler.resetMovement();
                encounterHandler.createEncounter(map.getTerrainType());
                activeEncounter = true;
                notifyObservers();
            }
        }
    }

    public boolean reachedTransporter() {
        return map.hasTransporter(player.getCoordinates());
    }
    private boolean doesEncounterStart(){
        if(map.tryEncounter(player.getCoordinates())) {
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

    public void playerBlackout() {
        changeMap("assets/maps/villagehouse.tmx");
    }

    public boolean isInEncounter() {
        return activeEncounter;
    }

    public void resetIsInEncounter() {
        activeEncounter = false;
    }

    public void subscribeMapObserver(IMapObserver observer) {
        mapObservers.add(observer);
    }

    private void activateTransporter() {
        // Get transporter data for the given position
        Transporter transporter = map.getTransporter(player.getCoordinates());

        // Load the new map, and tell the player to transport
        changeMap(transporter.getMapAssetPath());
        player.useTransporter(transporter);
    }

    private void changeMap(String mapAssetPath) {
        map = MapParser.parseMapFile(mapAssetPath);
        player.setPosition(map.getStartPosX(), map.getStartPosY());
        notifyMapObservers(mapAssetPath);
    }

    private void notifyMapObservers(String mapAssetPath) {
        for (IMapObserver observer : mapObservers) {
            observer.updateMap(mapAssetPath);
        }
    }
}
