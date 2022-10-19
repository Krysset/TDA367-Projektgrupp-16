package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;

/**
 * This class is responsible for translating an input direction from the controller to a new position for the player
 */
public class MovementHandler {
    private long moveFrequency = 500;
    private long lastMoved = 0;
    private int dirX = 0;
    private int dirY = 0;

    /**
     * Decreases the movement speed in the x-direction
     */
    public void decreaseXDirection(){
        dirX -= 1;
        dirX = Math.max(-1, dirX);
    }

    /**
     * Increases the movement speed in the x-direction
     */
    public void increaseXDirection(){
        dirX += 1;
        dirX = Math.min(1,dirX);
    }

    /**
     * Decreases the movement speed in the y-direction
     */
    public void decreaseYDirection(){
        dirY -= 1;
        dirY = Math.max(-1, dirY);
    }

    /**
     * Increases the movement speed in the y-direction
     */
    public void increaseYDirection(){
        dirY += 1;
        dirY = Math.min(1,dirY);

    }

    /**
     * Resets the movement speed in the x-direction
     */
    public void resetXDirection(){
        dirX = 0;
    }

    /**
     * Resets the movement speed in the y-direction
     */
    public void resetYDirection(){
        dirY = 0;
    }

    /**
     * Executes a movement update, based on the current direction.
     * @param coordinates the coordinates you want to base calculations from
     * @param map the map of the world in which the player is moving
     * @return the new direction adjusted for time and collision.
     */
    public Point calculateMovement(Point coordinates, Map map) {
        if (dirX == 0 && dirY == 0) return new Point(0,0);
        if(!hasTimeSinceLastMovedPassed()) return new Point(0,0);
        Point dir = adjustDirectionForCollision(coordinates, map);
        return dir;
    }

    /**
     * Resets the movement in both the x- and the y-direction
     */
    public void resetMovement(){
        resetXDirection();
        resetYDirection();
    }

    /**
     * Adjust the x and y direction values to avoid collision.
     */
    private Point adjustDirectionForCollision(Point coordinates, Map map) {
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
     * Checks if player is allowed to move according to time passed
     */
    private boolean hasTimeSinceLastMovedPassed(){
        long elapsedTime = TimeService.getElapsedTime();
        if(lastMoved + moveFrequency <= elapsedTime || lastMoved == 0){
            lastMoved = elapsedTime;
            return true;
        }
        return false;
    }

    /**
     * Checks if the new position is a collision
     * @param x the x-coordinate of the new position
     * @param y the y-coordinate of the new position
     * @param map the map of the world in which the player is moving
     * @return true if the new position is a collision, false otherwise
     */
    private boolean isNewPositionCollision(int x, int y, Map map) {
        return map.isCollision(x, y);
    }
}
