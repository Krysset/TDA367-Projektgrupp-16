package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Texture;

public class Tileset {
    // TODO: Figure out if texture or textureregion should be used
    private int firstgid, tileWidth, tileHeight, tileCount, columns;
    private String name;

    public Tileset(Texture texture, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        this.name = name;
        this.firstgid = firstgid;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tileCount = tileCount;
        this.columns = columns;
    }

    public void UnloadContent() {
        // TODO: Unload future tileset content
    }

    public int getFirstgid() {
        return firstgid;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileCount() {
        return tileCount;
    }

    public int getColumns() {
        return columns;
    }

    public String getName() {
        return name;
    }
}
