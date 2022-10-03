package com.g16.feyrune.view.overworld.textureMap.Tileset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureGettable;
import com.g16.feyrune.view.overworld.textureMap.TextureTile.TextureTile;

import java.util.HashMap;

public class Tileset {
    private final HashMap<Integer, ITextureGettable> gidTileMap;
    private final int firstgid, tileWidth, tileHeight, tileCount, columns;
    private final String name;

    protected Tileset(String imgSource, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        this.name = name;
        this.firstgid = firstgid;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tileCount = tileCount;
        this.columns = columns;
        Texture texture = new Texture(imgSource);
        TextureRegion[][] textureRegion = TextureRegion.split(texture, tileWidth, tileHeight);
        gidTileMap = initializeMap(textureRegion);
    }

    private HashMap<Integer, ITextureGettable> initializeMap(TextureRegion[][] textureRegion) {
        HashMap<Integer, ITextureGettable> map = new HashMap<>();
        for(int i = 0; i < textureRegion.length; i++) {
            for (int j = 0; j < textureRegion[i].length; j++) {
                map.put(i * textureRegion[i].length + j, new TextureTile(textureRegion[i][j]));
            }
        }
        return map;
    }

    protected ITextureGettable getTextureTile(int gid) {
        int id = gid-firstgid;
        if (id < 0 || id >= tileCount) {
            throw new RuntimeException("Invalid gid for tileset");
        }
        if (!gidTileMap.containsKey(id)) {
            // if all tiles were added correctly this line should *never* be reached!!
            throw new RuntimeException("Given id does not exist in tileset...");
        }
        ITextureGettable tile = gidTileMap.get(id);
        return tile;
    }

    protected int getTileCount() {
        return tileCount;
    }

    protected String getName() {
        return name;
    }
}
