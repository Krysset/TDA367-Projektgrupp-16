package com.g16.feyrune.model.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.model.Player;
import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.model.map.parser.Map;

import java.awt.*;

public class MovementHandler {
    private Player player;
    private long moveFrequency = 250;
    private long lastMoved = 0;
    private int dirX = 0;
    private int dirY = 0;

    public MovementHandler(Player player) {
        this.player = player;
    }

    public void decreaseXDirection(){
        dirX -= 1;
        dirX = Math.max(-1, dirX);
    }

    public void increaseXDirection(){
        dirX += 1;
        dirX = Math.min(1,dirX);
    }

    public void decreaseYDirection(){
        dirY -= 1;
        dirY = Math.max(-1, dirY);
    }

    public void increaseYDirection(){
        dirY += 1;
        dirY = Math.min(1,dirY);

    }

    /**
     * Executes a movement update, based on the current direction.
     */
    public void executeMovement() {
        if (dirX == 0 && dirY == 0) return;
        if(!hasTimeSinceLastMovedPassed()) return;
        Point dir = adjustDirectionForCollision();
        System.out.println(":)");
        player.move(dir.x, dir.y);
        //resetDirection();
    }

    /**
     * Adjust the x and y direction values to avoid collision.
     */
    private Point adjustDirectionForCollision() {
        int playerX = player.getPosX();
        int playerY = player.getPosY();
        Point dir = new Point(dirX,dirY);

        if (isNewPositionCollision(playerX + dir.x, playerY + dir.y)) {
            dir.x = 0;
            dir.y = 0;
            return dir;
        }

        if (isNewPositionCollision(playerX + dir.x, playerY)) {
            dir.x = 0;
        }
        if (isNewPositionCollision(playerX, playerY + dir.y)) {
            dir.y = 0;
        }
        return dir;
    }

    private boolean hasTimeSinceLastMovedPassed(){
        long elapsedTime = TimeService.getElapsedTime();
        if(lastMoved + moveFrequency <= elapsedTime || lastMoved == 0){
            lastMoved = elapsedTime;
            return true;
        }
        return false;
    }

    private void resetDirection() {
        dirX = 0;
        dirY = 0;
    }

    private boolean isNewPositionCollision(int x, int y) {
        return Map.getGlobalMap().getTile(x, y).isCollision();
    }
}
