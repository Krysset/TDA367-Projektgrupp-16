package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureGettable;

import java.awt.*;
import java.util.HashMap;

public class TextureLayer {
    private final HashMap<Point, ITextureGettable> layer;

    /**
     * Constructor for the TextureLayer
     */
    protected TextureLayer() {
        layer = new HashMap<>();
    }

    /**
     * Adds a tile to the layer
     * @param spriteBatch the sprite batch
     * @param tileSize the size of the tile
     */
    public void render(SpriteBatch spriteBatch, int tileSize) {
        for (HashMap.Entry<Point, ITextureGettable> entry : layer.entrySet()) {
            Point coordinate = entry.getKey();
            ITextureGettable tile = entry.getValue();
            spriteBatch.draw(tile.getTexture(), coordinate.x * tileSize, coordinate.y * tileSize);
        }
    }

    /**
     * Adds a tile to the layer
     * @param coordinate the coordinate of the tile
     * @param tile the tile to add
     */
    protected void addTile(Point coordinate, ITextureGettable tile) {
        layer.put(coordinate, tile);
    }
}
