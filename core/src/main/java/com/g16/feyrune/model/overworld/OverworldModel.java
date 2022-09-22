package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;
    private Map map;

    public OverworldModel(Player player) {
        this.player = player;
        this.movementHandler = new MovementHandler();
        this.map = Map.getGlobalMap();
    }

    public void update(){
        movePlayer();
    }

    public void movePlayer() {
        Point deltaPos = movementHandler.calculateMovement(player.getCoordinates(), map);
        player.move(deltaPos.x, deltaPos.y);
    }

    public MovementHandler getMovementHandler() {
        return movementHandler;
    }
}
