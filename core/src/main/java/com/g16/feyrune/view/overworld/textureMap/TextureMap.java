package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class TextureMap {

    private final List<TextureLayer> layers;

    private final Color backgroundColor;

    private final int tileWidth, tileHeight;

    private final int mapWidth, mapHeight;

    public TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor, List<TextureLayer> layers) {
        this.layers = layers;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.backgroundColor = backgroundColor;
    }

    public void render(SpriteBatch batch) {
        for (TextureLayer layer : layers) {
            layer.render(batch);
        }
    }

    public Color getBgColor() {
        return new Color(backgroundColor);
    }

    public int getTileSize() {
        return tileWidth;
    }
}
