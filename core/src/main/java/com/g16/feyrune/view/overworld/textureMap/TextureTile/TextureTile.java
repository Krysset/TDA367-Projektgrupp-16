package com.g16.feyrune.view.overworld.textureMap.TextureTile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
