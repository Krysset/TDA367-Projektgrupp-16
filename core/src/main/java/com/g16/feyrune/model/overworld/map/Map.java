package com.g16.feyrune.model.overworld.map;

import com.g16.feyrune.model.player.Player;

import java.awt.*;

public class Map {
    private static Map globalMap;

    private final Tile[][] tiles;
    private final int width;
    private final int height;
    private final int startPosX;
    private final int startPosY;

    protected Map(Tile[][] tiles, int startPosX, int startPosY) {
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

    public Tile getTile(int xPos, int yPos){
        return tiles[xPos][yPos];
    }
    public Tile getTile(Point point){
        return getTile(point.x, point.y);
    }

    public static Map getGlobalMap() {
        if (globalMap == null) {
            // "assets/maps/dungeon1.tmx"
            // "assets/maps/plains1.tmx"
            // "assets/maps/shop.tmx"
            // "assets/maps/villagehouse.tmx"
            globalMap = MapParser.parseMapFile("assets/maps/plains1.tmx");
        }
        return globalMap;
    }
    public boolean tryEncounter(Point playerPos){
        if (getTile(playerPos).canEncounter()){
            return true;
        }
        return false;
    }
    public void removeEncounterFromTile(Point tilePos){
        tiles[tilePos.x][tilePos.y].removeEncounter();
    }
    public String getTerrainType(){
        return "dungeon";
    }

    public int getStartPosX() {
        return startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }
}
