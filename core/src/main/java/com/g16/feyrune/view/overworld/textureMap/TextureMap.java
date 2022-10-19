package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureMap {
    private final Iterable<TextureLayer> layers;
    private final Color backgroundColor;
    private final int tileWidth, tileHeight;
    private final int mapWidth, mapHeight;

    /**
     * Constructor for the TextureMap
     * @param mapWidth the width of the map
     * @param mapHeight the height of the map
     * @param tileWidth the width of the tiles
     * @param tileHeight the height of the tiles
     * @param backgroundColor the background color of the map
     * @param layers the layers of the map
     */
    protected TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor, Iterable<TextureLayer> layers) {
        this.layers = layers;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.backgroundColor = backgroundColor;
    }

    /**
     * Draws the map
     * @param batch the sprite batch to draw with
     */
    public void render(SpriteBatch batch) {
        for (TextureLayer layer : layers) {
            layer.render(batch, tileWidth);
        }
    }

    /**
     * Returns the background colour of the map
     * @return the background colour of the map
     */
    public Color getBgColor() {
        return new Color(backgroundColor);
    }

    /**
     * Returns the width of each tile in the map
     * @return the width of each tile in the map
     */
    public int getTileSize() {
        return tileWidth;
    }
}
