package com.g16.feyrune.model.map;

import com.g16.feyrune.model.Player;
import com.g16.feyrune.model.map.parser.Map;

public class MovementHandler {
    private Player player;
    private int moveFrequency;
    private int lastMoved = 0;
    private int dirX = 0;
    private int dirY = 0;

    public MovementHandler(Player player) {
        this.player = player;
    }

    public void decreaseXDirection(){
        dirX = -1;
    }

    public void increaseXDirection(){
        dirX = 1;
    }

    public void decreaseYDirection(){
        dirY = -1;
    }

    public void increaseYDirection(){
        dirY = 1;
    }

    /**
     * Executes a movement update, based on the current direction.
     */
    public void executeMovement() {
        if (dirX == 0 && dirY == 0) return;

        adjustDirectionForCollision();
        player.move(dirX, dirY);
        resetDirection();
    }

    /**
     * Adjust the x and y direction values to avoid collision.
     */
    private void adjustDirectionForCollision() {
        int playerX = player.getPosX();
        int playerY = player.getPosY();

        if (isNewPositionCollision(playerX + dirX, playerY + dirY)) {
            dirX = 0;
            dirY = 0;
            return;
        }

        if (isNewPositionCollision(playerX + dirX, playerY)) {
            dirX = 0;
        }
        if (isNewPositionCollision(playerX, playerY + dirY)) {
            dirY = 0;
        }
    }

    private void resetDirection() {
        dirX = 0;
        dirY = 0;
    }

    private boolean isNewPositionCollision(int x, int y) {
        return Map.getGlobalMap().getTile(x, y).isCollision();
    }
}
