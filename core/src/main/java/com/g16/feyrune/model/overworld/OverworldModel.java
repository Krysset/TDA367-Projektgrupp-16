package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.Player;

public class OverworldModel {
    private Player player;
    private MovementHandler movementHandler;

    public OverworldModel(Player player) {
        this.player = player;
        this.movementHandler = new MovementHandler();
    }

    public void movePlayer(int x, int y) {

        player.move(x, y);
    }

}
