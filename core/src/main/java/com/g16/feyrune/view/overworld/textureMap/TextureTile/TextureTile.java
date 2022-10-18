package com.g16.feyrune.view.overworld.textureMap.TextureTile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureTile implements ITextureGettable {
    private final TextureRegion texture;

    /**
     * Constructor for the TextureTile
     * @param texture the texture of the tile
     */
    public TextureTile(TextureRegion texture) {
        this.texture = texture;
    }

    /**
     * Gets the texture of the tile
     * @return the texture of the tile
     */
    @Override
    public TextureRegion getTexture() {
        return texture;
    }
}
