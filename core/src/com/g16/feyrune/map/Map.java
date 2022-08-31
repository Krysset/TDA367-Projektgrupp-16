package com.g16.feyrune.map;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Map {
    private final Tile[][] tiles;
    private int width;
    private int height;

    private Map(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public static Map getGlobalMap() {
        throw new NotImplementedException();
    }

}
