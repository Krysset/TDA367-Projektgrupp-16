package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;
    private EncounterHandler encounterHandler;
    private Map map;

    private boolean inEncounter=false;

    public OverworldModel(Player player) {
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.map = Map.getGlobalMap();
        this.encounterHandler = new EncounterHandler();
    }

    public void update(){
        movePlayer();
    }

    public void movePlayer() {
        Point deltaPos = movementHandler.calculateMovement(player.getCoordinates(), map);
        player.move(deltaPos.x, deltaPos.y);
        if (map.tryEncounter(player.getCoordinates())) {
            encounterHandler.createEncounter(map.getTerrainType());
            System.out.println("Encounter!");
            inEncounter = true;
        }
    }

    public boolean isInEncounter(){
        return inEncounter;
    }
    public void endEncounter(){
        inEncounter=false;
    }


    public MovementHandler getMovementHandler() {
        return movementHandler;
    }
}
