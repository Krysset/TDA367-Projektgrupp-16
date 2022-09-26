package com.g16.feyrune.model.overworld.map;

import com.g16.feyrune.model.player.Player;

import java.awt.*;

public class Map {
    private static Map globalMap;

    private final Tile[][] tiles;
    private final int width;
    private final int height;

    protected Map(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
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
            globalMap = MapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
        }
        return globalMap;
    }
    public boolean tryEncounter(Point playerPos){
        if (getTile(playerPos).canEncounter()){
            return true;
        }
        return false;
    }
    public String getTerrainType(){
        return "dungeon";
    }
}
