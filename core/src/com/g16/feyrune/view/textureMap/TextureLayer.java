package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureLayer {
    private TextureTile[][] textureTileMap;
    private String name;
    private int mapWidth, mapHeight, tileWidth, tileHeight;
    private float layer;

    public TextureLayer(String name, int mapWidth, int mapHeight, int tileWidth, int tileHeight, float layer) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.layer = layer;
        this.name = name;
        textureTileMap = new TextureTile[mapWidth][mapHeight];
    }

    public void draw(SpriteBatch batch) {
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                // TODO: draw tiles with batch
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setTile(int pos, TextureTile tile) {
        int x = pos % mapWidth;
        int y = pos / mapWidth;
        // TODO: set x,y to tile
    }
}
