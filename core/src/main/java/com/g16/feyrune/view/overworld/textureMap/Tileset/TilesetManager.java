package com.g16.feyrune.view.overworld.textureMap.Tileset;

import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureGettable;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class TilesetManager {
    SortedMap<Integer, Tileset> sortedTilesets;
    public TilesetManager() {
        sortedTilesets = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
    }
    public void addTileset(String imgSource, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        Tileset tileset = new Tileset(imgSource, name, firstgid, tileWidth, tileHeight, tileCount, columns);
        sortedTilesets.put(firstgid, tileset);
    }
    public ITextureGettable getITextureTileFromGId(int gid) {
        if(sortedTilesets.isEmpty()) {
            throw new RuntimeException("No tilesets have been added");
        }
        for (int firstGId : sortedTilesets.keySet()) {
            if (firstGId < gid) {
                Tileset tileset = sortedTilesets.get(firstGId);
                ITextureGettable tile = tileset.getTextureTile(gid);
                return tile;
            }
        }
        throw new RuntimeException("Couldn't find TextureTile associated to gid");
    }
}
