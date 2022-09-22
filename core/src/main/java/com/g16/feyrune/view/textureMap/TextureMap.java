package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class TextureMap {
    private int mapWidth, mapHeight, tileWidth, tileHeight;
    private Color bgColor;

    private List<TextureLayer> layers;

    public TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor,
                      List<TextureLayer> layers) {
        this.bgColor = backgroundColor;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.layers = layers;
    }
    public void draw(SpriteBatch spriteBatch) {
        for(TextureLayer layer : layers) {
            layer.draw(spriteBatch);
        }
    }

    public Color getBackgroundColor() {
        return bgColor;
    }

    public int getTileSize() {
        return tileWidth;
    }
}
