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
import java.io.File;
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

    /**
     * Constructor for the OverworldModel class
     * @param player the player
     */
    public OverworldModel(Player player) {
       this(player,"/maps/plains1.tmx");
    }
    public OverworldModel(Player player, String path) {
        activeEncounter = false;
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.encounterHandler = new EncounterHandler();
        this.observerList = new ArrayList<>();
        mapObservers = new ArrayList<>();
        changeMap(path);
    }

    /**
     * Adds another observer to the overworldModel
     * @param observer the observer to be added
     */
    public void addObserver(IObserver observer){
        observerList.add(observer);
    }

    /**
     * Starts the next execution cycle in the overworld
     */
    public void update(){
        movePlayer();
    }

    /**
     * Checks if the player can move and if it should, and in that case moves it.
     */
    protected void movePlayer() {
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

    /**
     * Checks if the player has reached a transporter
     * @return true if the player has reached a transporter, false otherwise
     */
    public boolean reachedTransporter() {
        return map.hasTransporter(player.getCoordinates());
    }

    /**
     * Tries to start an encounter
     * @return true if an encounter should be started, false otherwise
     */
    private boolean doesEncounterStart(){
        if(map.tryEncounter(player.getCoordinates())) {
            // about every tenth tile is an encounter
            return Random.randomInt(100) > 90;
        }
        return false;
    }

    /**
     * Returns the movementHandler
     * @return the movementHandler
     */
    public MovementHandler getMovementHandler() {
        return movementHandler;
    }

    /**
     * Calls observerUpdate() on all observers in observerList
     */
    private void notifyObservers(){
        for (IObserver observer : observerList) {
            observer.observerUpdate();
        }
    }

    /**
     * Returns the encounter
     * @return the encounter
     */
    public Encounter getEncounter(){
        return encounterHandler.createEncounter("dungeon");
    }

    /**
     * Respawns the player
     */
    public void playerBlackout() {
        changeMap(new File("").getAbsolutePath()+"/maps/villagehouse.tmx");
    }

    /**
     * Checks if the player is in an active encounter
     * @return true if the player is in an active encounter, false otherwise
     */
    public boolean isInEncounter() {
        return activeEncounter;
    }

    /**
     * Ends the encounter
     */
    public void resetIsInEncounter() {
        activeEncounter = false;
    }

    /**
     * Adds a mapobserver to the mapObservers list
     * @param observer the mapobserver to be added
     */
    public void subscribeMapObserver(IMapObserver observer) {
        mapObservers.add(observer);
    }

    /**
     * Uses the transporter on the current tile
     */
    private void activateTransporter() {
        // Get transporter data for the given position
        Transporter transporter = map.getTransporter(player.getCoordinates());

        // Load the new map, and tell the player to transport
        changeMap(transporter.getMapAssetPath());
        player.useTransporter(transporter);
    }

    /**
     * Changes the map to the map with the given path
     * @param mapAssetPath the path to the map
     */
    private void changeMap(String mapAssetPath) {
        map = MapParser.parseMapFile(mapAssetPath);
        player.setPosition(map.getStartPosX(), map.getStartPosY());
        notifyMapObservers(mapAssetPath);
    }

    /**
     * Calls mapObserverUpdate() on all mapObservers in mapObservers
     * @param mapAssetPath the path to the map
     */
    private void notifyMapObservers(String mapAssetPath) {
        for (IMapObserver observer : mapObservers) {
            observer.updateMap(mapAssetPath);
        }
    }
}
