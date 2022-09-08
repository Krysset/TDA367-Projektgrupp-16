package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class TextureMap {
    private int mapWidth, mapHeight, tileWidth, tileHeight;
    private Color bgColor;
    private List<TextureLayer> layers;
    private List<Tileset> tilesets;

    public TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor) {
        this.bgColor = backgroundColor;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        layers = new ArrayList<>();
        tilesets = new ArrayList<>();
    }
    public void draw(SpriteBatch spriteBatch) {
        for (TextureLayer layer : layers) {
            layer.draw(spriteBatch);
        }
    }

    public void addLayer(TextureLayer layer) {
        layers.add(layer);
    }
    public void addTile(String layerName, TextureTile tile, int pos) {
        for(TextureLayer layer : layers) {
            if(layer.getName() == layerName) {
                layer.setTile(pos, tile);
            }
        }
    }
    public void unloadContent() {
        for(Tileset tileset : tilesets) {
            tileset.unloadContent();
        }
    }

}
