package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureTile;

import java.awt.*;
import java.util.HashMap;

public class TextureLayer {
    private HashMap<Point, ITextureTile> layer;

    public TextureLayer() {
        layer = new HashMap<>();
    }
    public void render(SpriteBatch spriteBatch) {
        for (HashMap.Entry<Point, ITextureTile> entry : layer.entrySet()) {
            Point coordinate = entry.getKey();
            ITextureTile tile = entry.getValue();
            spriteBatch.draw(tile.getTexture(), coordinate.x * 16, coordinate.y * 16);
        }
    }

    public void addTile(Point coordinate, ITextureTile tile) {
        layer.put(coordinate, tile);
    }
}
