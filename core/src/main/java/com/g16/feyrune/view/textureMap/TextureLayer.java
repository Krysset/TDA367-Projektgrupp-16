package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.view.textureMap.TextureTile.ITextureTile;

import java.awt.*;
import java.util.HashMap;

public class TextureLayer {
    private HashMap<Point, ITextureTile> layer;

    public TextureLayer() {
        layer = new HashMap<>();
    }
    public void draw(SpriteBatch spriteBatch) {
        for (HashMap.Entry<Point, ITextureTile> entry : layer.entrySet()) {
            Point coordinate = entry.getKey();
            ITextureTile tile = entry.getValue();
            spriteBatch.draw(tile.getTexture(), coordinate.x, coordinate.y);
        }
    }

    public void addTile(Point coordinate, ITextureTile tile) {
        layer.put(coordinate, tile);
    }
}
