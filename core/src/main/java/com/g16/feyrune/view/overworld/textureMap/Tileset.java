package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tileset {
    private TextureRegion[][] textureRegion;
    private final int firstgid, tileWidth, tileHeight, tileCount, columns;
    private final String name;

    public Tileset(String imgSource, String name, int firstgid, int tileWidth, int tileHeight, int tileCount, int columns) {
        this.name = name;
        this.firstgid = firstgid;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tileCount = tileCount;
        this.columns = columns;
        Texture texture = new Texture(imgSource);
        textureRegion = TextureRegion.split(texture, tileWidth, tileHeight);
    }

    public TextureRegion getTextureRegion(int gid) {
        int newGid = gid-firstgid;
        if (newGid < 0 || newGid >= tileCount) {
            throw new RuntimeException("Invalid gid for tileset");
        }
        return textureRegion[newGid / columns][newGid % columns];
    }

    public int getFirstgid() {
        return firstgid;
    }

    public int getTileCount() {
        return tileCount;
    }

    public String getName() {
        return name;
    }
}
