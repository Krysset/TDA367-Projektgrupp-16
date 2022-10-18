package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Map {
    private final Tile[][] tiles;
    private final String terrainType;
    private final int width;
    private final int height;
    private int startPosX;
    private int startPosY;


    protected Map(String name, Tile[][] tiles, int startPosX, int startPosY) {
        this.terrainType = name;
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean tryEncounter(Point playerPos){
        return getTile(playerPos).canEncounter();
    }

    public String getTerrainType(){
        return terrainType;
    }

    public int getStartPosX() {
        return startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public boolean hasTransporter(Point playerPos){
        return getTile(playerPos).hasTransporter();
    }

    public Transporter getTransporter(Point pos){
        return getTile(pos).getTransporter();
    }

    public boolean isCollision(int x, int y) {
        return getTile(x, y).isCollision();
    }

    protected void setStartPos(Point newStartPos) {
        startPosX = newStartPos.x;
        startPosY = newStartPos.y;
    }

    private Tile getTile(int xPos, int yPos){
        return tiles[xPos][yPos];
    }

    private Tile getTile(Point point){
        return getTile(point.x, point.y);
    }
}
