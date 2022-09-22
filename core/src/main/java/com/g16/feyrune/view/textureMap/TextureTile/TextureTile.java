package com.g16.feyrune.view.textureMap.TextureTile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;
import java.util.HashMap;

public class TextureTile implements ITextureTile {
    private TextureRegion texture;

    public TextureTile(TextureRegion texture) {
        this.texture = texture;
    }
    @Override
    public TextureRegion getTexture() {
        return texture;
    }
}
