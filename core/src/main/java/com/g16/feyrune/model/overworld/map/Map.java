package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Map {
    private static Map globalMap;

    private final int startPosX;
    private final int startPosY;
    private final Tile[][] tiles;
    private final int width;
    private final int height;

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

    public int getStartPosX() {
        return startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public static Map getGlobalMap() {
        if (globalMap == null) {
            globalMap = MapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
        }
        return globalMap;
    }
}
