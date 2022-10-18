package com.g16.feyrune.view.overworld.textureMap.Tileset;

import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureGettable;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TilesetManager {
    private SortedMap<Integer, Tileset> sortedTilesets;

    /**
     * Constructor for the TilesetManager
     */
    public TilesetManager() {
        sortedTilesets = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
    }

    /**
     * Adds a tileset to the tilesetManager
     * @param imgSource the path to the image
     * @param name the name of the tileset
     * @param firstgid the first gid of the tileset
     * @param tileWidth the width of the tiles
     * @param tileHeight the height of the tiles
     * @param tileCount the number of tiles in the tileset
     * @param columns the number of columns in the tileset
     */
    public void addTileset(String imgSource, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        Tileset tileset = new Tileset(imgSource, name, firstgid, tileWidth, tileHeight, tileCount, columns);
        sortedTilesets.put(firstgid, tileset);
    }

    /**
     * Gets the texture of the tile using gid
     * @param gid the gid of the tile to get
     * @return the texture of the tile containing gid gid
     */
    public ITextureGettable getITextureTileFromGId(int gid) {
        if(sortedTilesets.isEmpty()) {
            throw new RuntimeException("No tilesets have been added");
        }
        for (int firstGId : sortedTilesets.keySet()) {
            if (firstGId <= gid) {
                Tileset tileset = sortedTilesets.get(firstGId);
                ITextureGettable tile = tileset.getTextureTile(gid);
                return tile;
            }
        }
        throw new RuntimeException("Couldn't find TextureTile associated to gid");
    }
}
