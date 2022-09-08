package com.g16.feyrune.view.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerRenderer {
    private final TextureRegion currentTexture; // This is just temporary, until we figure out the animation handling.
    private final Texture texture;

    public PlayerRenderer(Texture texture, int x, int y, int width, int height) {
        this.texture = texture;
        currentTexture = new TextureRegion(texture, x, y, width, height);
    }

    public void draw(Batch batch) {
        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();
        batch.draw(currentTexture, screenWidth / 2f - (currentTexture.getRegionWidth() / 2f),
                screenHeight / 2f - (currentTexture.getRegionHeight() / 2f));
    }

    public void dispose() {
        texture.dispose();
    }
}
