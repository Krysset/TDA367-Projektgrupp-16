package com.g16.feyrune.view.player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.g16.feyrune.view.utils.AnimationUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerRenderer {
    private final TextureRegion currentTexture; // This is just temporary, until we figure out the animation handling.
    private final Texture texture;
    private final TextureRegion[] walkRightAnimation;

    float stateTime = 0;

    public PlayerRenderer(Texture texture, int x, int y, int width, int height) {
        this.texture = texture;
        currentTexture = new TextureRegion(texture, x, y, width, height);
        walkRightAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 16);
    }

    public void draw(Batch batch) {
        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        Animation<TextureRegion> animation = animate(walkRightAnimation);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        batch.draw(animation.getKeyFrame(stateTime), screenWidth / 2f - (currentTexture.getRegionWidth() / 2f),
                screenHeight / 2f - (currentTexture.getRegionHeight() / 2f));
    }

    public Animation<TextureRegion> animate(TextureRegion[] animation){
        return new Animation<TextureRegion>(0.15f, animation);
    }

    public void dispose() {
        texture.dispose();
    }
}
