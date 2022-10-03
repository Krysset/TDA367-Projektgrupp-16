package com.g16.feyrune.view.overworld.textureMap.TextureTile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimatedTextureTile implements ITextureTile {

    private float elapsedTime;
    private Animation<TextureRegion> animation;

    public AnimatedTextureTile(Array<TextureRegion> frames, float animationSpeed) {
        elapsedTime = 0;
        animation = new Animation<TextureRegion>(animationSpeed, frames, Animation.PlayMode.LOOP);
    }

    @Override
    public TextureRegion getTexture() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        return animation.getKeyFrame(elapsedTime);
    }
}
