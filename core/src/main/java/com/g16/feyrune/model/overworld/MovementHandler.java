package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;

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

    /**
     * Executes a movement update, based on the current direction.
     */
    public Point calculateMovement(Point coordinates, Map map) {
        if (dirX == 0 && dirY == 0) return new Point(0,0);
        if(!hasTimeSinceLastMovedPassed()) return new Point(0,0);
        Point dir = adjustDirectionForCollision(coordinates, map);
        return dir;
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

    private boolean isNewPositionCollision(int x, int y, Map map) {
        return map.getTile(x, y).isCollision();
    }
}
