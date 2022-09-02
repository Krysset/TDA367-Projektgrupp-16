package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tileset {
    private TextureRegion textureRegion;
    private int firstgid, tileWidth, tileHeight, tileCount, columns;
    private String name;

    public Tileset(String imgSource, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        this.name = name;
        this.firstgid = firstgid;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tileCount = tileCount;
        this.columns = columns;
        // TODO: Load textureregion or texture
    }

    public void unloadContent() {
        textureRegion.getTexture().dispose();
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
