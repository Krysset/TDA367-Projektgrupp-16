package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.view.overworld.textureMap.TextureTile.ITextureGettable;

import java.awt.*;
import java.util.HashMap;

public class TextureLayer {
    private final HashMap<Point, ITextureGettable> layer;

    protected TextureLayer() {
        layer = new HashMap<>();
    }
    public void render(SpriteBatch spriteBatch) {
        for (HashMap.Entry<Point, ITextureGettable> entry : layer.entrySet()) {
            Point coordinate = entry.getKey();
            ITextureGettable tile = entry.getValue();
            spriteBatch.draw(tile.getTexture(), coordinate.x * 16, coordinate.y * 16);
        }
    }

    protected void addTile(Point coordinate, ITextureGettable tile) {
        layer.put(coordinate, tile);
    }
}
