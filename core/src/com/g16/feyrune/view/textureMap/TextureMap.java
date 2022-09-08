package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TextureMap {
    private int mapWidth, mapHeight, tileWidth, tileHeight;
    private Color bgColor;
    private List<TextureLayer> layers;
    private List<Tileset> tilesets;

    public TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor, List<Tileset> tilesets, List<TextureLayer> layers) {
        this.bgColor = backgroundColor;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.tilesets = tilesets;
        this.layers = layers;
    }
    public void draw(SpriteBatch spriteBatch) {
        for (TextureLayer layer : layers) {
            layer.draw(spriteBatch, tilesets);
        }
    }
    public void unloadContent() {
        for(Tileset tileset : tilesets) {
            tileset.unloadContent();
        }
    }

}
