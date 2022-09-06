package com.g16.feyrune.map;

import com.g16.feyrune.model.Parser.Parser;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Map {
    private static Map globalMap;

    private final Tile[][] tiles;
    private final int width;
    private final int height;

    public Map(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("Map (").append(width).append(", ").append(height).append("):\n");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(tiles[j][i].hasCollision() ? "1 " : "0 ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public Tile getTile(int xPos, int yPos){
        return tiles[xPos][yPos];
    }

    public static Map getGlobalMap() {
        if (globalMap == null) {
            globalMap = Parser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
        }
        return globalMap;
    }

}
