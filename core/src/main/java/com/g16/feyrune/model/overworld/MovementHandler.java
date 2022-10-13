package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.model.overworld.map.MapManager;

import java.awt.*;

/**
 * This class is responsible for transelateing an inpout direction from the controller to a new position for the player
 */
public class MovementHandler {
    private long moveFrequency = 500;
    private long lastMoved = 0;
    private int dirX = 0;
    private int dirY = 0;

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
    public void resetXDirection(){
        dirX = 0;
    }
    public void resetYDirection(){
        dirY = 0;
    }

    /**
     * Executes a movement update, based on the current direction.
     * @param coordinates the coodinates you want to base calcutations from
     * @param map the mapManager
     * @return the new direction adjusted for time and colliton.
     */
    public Point calculateMovement(Point coordinates, MapManager map) {
        if (dirX == 0 && dirY == 0) return new Point(0,0);
        if(!hasTimeSinceLastMovedPassed()) return new Point(0,0);
        Point dir = adjustDirectionForCollision(coordinates, map);
        return dir;
    }
    public void resetMovement(){
        resetXDirection();
        resetYDirection();
    }

    /**
     * Adjust the x and y direction values to avoid collision.
     */
    private Point adjustDirectionForCollision(Point coordinates, MapManager map) {
        int playerX = coordinates.x;
        int playerY = coordinates.y;
        Point dir = new Point(dirX,dirY);

        if (isNewPositionCollision(playerX + dir.x, playerY + dir.y, map)) {
            dir.x = 0;
            dir.y = 0;
            return dir;
        }

        if (isNewPositionCollision(playerX + dir.x, playerY, map)) {
            dir.x = 0;
        }
        if (isNewPositionCollision(playerX, playerY + dir.y, map)) {
            dir.y = 0;
        }
        return dir;
    }


    /**
     * Chekes if player is allowed to move accoring to time passed
     */
    private boolean hasTimeSinceLastMovedPassed(){
        long elapsedTime = TimeService.getElapsedTime();
        if(lastMoved + moveFrequency <= elapsedTime || lastMoved == 0){
            lastMoved = elapsedTime;
            return true;
        }
        return false;
    }

    private boolean isNewPositionCollision(int x, int y, MapManager map) {
        return map.isCollision(x, y);
    }
}
