package com.g16.feyrune.view.overworld.textureMap.TextureTile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedTextureTile implements ITextureGettable {
    private float elapsedTime;
    private Animation<TextureRegion> animation;

    /**
     * Constructor for the AnimatedTextureTile
     * @param frames Array of texture for all frames
     * @param animationSpeed fps of animation
     */
    public AnimatedTextureTile(Array<TextureRegion> frames, float animationSpeed) {
        elapsedTime = 0;
        animation = new Animation<TextureRegion>(animationSpeed, frames, Animation.PlayMode.LOOP);
    }

    /**
     * Gets the current frame of the animation
     * @return the current frame of the animation
     */
    @Override
    public TextureRegion getTexture() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        return animation.getKeyFrame(elapsedTime);
    }
}
