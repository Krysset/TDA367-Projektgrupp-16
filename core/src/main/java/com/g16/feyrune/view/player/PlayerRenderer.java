package com.g16.feyrune.view.player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.model.Player;
import com.g16.feyrune.view.utils.AnimationUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerRenderer {
    private final Texture texture;
    private final TextureRegion[] walkRightAnimation;
    private final TextureRegion[] walkLeftAnimation;
    private TextureRegion[] currentAnimation;
    private String humanMalePath = "hero/humanmale/humanMale.png";
    private Player player;

    float stateTime = 0;

    public PlayerRenderer(Player player) {
        this.texture = new Texture(humanMalePath);
        walkRightAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 16);
        walkLeftAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 20);
        currentAnimation = walkRightAnimation;
        this.player = player;
    }

    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        Animation<TextureRegion> animation = animate(currentAnimation);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        batch.draw(animation.getKeyFrame(stateTime), player.getPosX() * 16,player.getPosY() * 16);
    }


    private Animation<TextureRegion> animate(TextureRegion[] animation){
        return new Animation<>(0.15f, animation);
    }

    public void dispose() {
        texture.dispose();
    }
}
