package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Map {
    private final Tile[][] tiles;
    private final int width;
    private final int height;
    private int startPosX;
    private int startPosY;

    protected Map(Tile[][] tiles, int startPosX, int startPosY) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
    }

    protected int getWidth() {
        return width;
    }

    protected int getHeight() {
        return height;
    }

    protected Tile getTile(int xPos, int yPos){
        return tiles[xPos][yPos];
    }
    protected Tile getTile(Point point){
        return getTile(point.x, point.y);
    }
    protected boolean tryEncounter(Point playerPos){
        if (getTile(playerPos).canEncounter()){
            return true;
        }
        return false;
    }
    protected String getTerrainType(){
        return "dungeon";
    }

    protected int getStartPosX() {
        return startPosX;
    }

    protected int getStartPosY() {
        return startPosY;
    }

    protected boolean hasTransporter(Point playerPos){
        return getTile(playerPos).hasTransporter();
    }
    protected Point getTransportCoordinates(Point transportCoordinates) {
        return getTile(transportCoordinates).getTransportCoordinates();
    }
    protected String getTransportMapAssetPath(Point transportCoordinates) {
        return getTile(transportCoordinates).getTransportMapAssetPath();
    }
    protected boolean hasCollision(int x, int y) {
        return getTile(x, y).hasCollision();
    }
    protected void setStartPos(Point newStartPos) {
        startPosX = newStartPos.x;
        startPosY = newStartPos.y;
    }
}
