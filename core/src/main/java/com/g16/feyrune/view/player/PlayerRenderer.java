package com.g16.feyrune.view.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.utils.AnimationUtils;

public class PlayerRenderer {
    private final Texture texture;
    private final TextureRegion[] walkRightAnimation;
    private final TextureRegion[] walkLeftAnimation;
    private final TextureRegion[] idleRightAnimation;
    private final TextureRegion[] idleLeftAnimation;
    private TextureRegion[] currentAnimation;
    private String humanMalePath = "hero/humanmale/humanMale.png";
    private Player player;

    private float moveSpeed = 0.5f;
    private float currentTime = 0;
    private float alpha = 0;
    private float idleTimer = 0;
    private boolean counting = false;

    private Vector2 playerPos;
    private Vector2 newPlayerPos;
    private int xfacingDirection = 1;

    float stateTime = 0;

    /**
     * Constructor for the PlayerRenderer
     * @param player the player to be rendered
     */
    public PlayerRenderer(Player player) {
        this.texture = new Texture(humanMalePath);
        walkRightAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 16);
        walkLeftAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 20);
        idleRightAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 0);
        idleLeftAnimation = AnimationUtils.getAnimationFrames(texture, 8, 6, 4, 4);
        currentAnimation = walkRightAnimation;
        this.player = player;
        playerPos = new Vector2(player.getCoordinates().x, player.getCoordinates().y);
        newPlayerPos = playerPos;
    }

    /**
     * Draws the player using the sprite batch
     * @param batch the sprite batch to draw with
     */
    public void draw(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        Animation<TextureRegion> animation = animate(currentAnimation);
        animation.setPlayMode(Animation.PlayMode.LOOP);

        calculateContinuousPosition(); //Calculate the viewed position (playerPos) using Vector2.larp
        pickAnimation();
        batch.draw(animation.getKeyFrame(stateTime), playerPos.x * 16-5, playerPos.y * 16);
    }

    /**
     * Calculates the position of the player using Vector2.lerp
     */
    private void calculateContinuousPosition(){
        if ((playerPos.x != player.getCoordinates().x || playerPos.y != player.getCoordinates().y) || alpha >= 1){
            newPlayerPos = new Vector2(player.getCoordinates().x,player.getCoordinates().y);
            alpha = calculateAlpha();
            playerPos.lerp(newPlayerPos, alpha);
        }
        else {alpha = 0; currentTime = 0;}
    }

    /**
     * Chooses which animation to use based on the player's movement
     */
    private void pickAnimation(){
        if (newPlayerPos.x - playerPos.x == 0 && newPlayerPos.y - playerPos.y == 0){
            if (counting){
                idleTimer -= Gdx.graphics.getDeltaTime();
                if (idleTimer <= 0){
                    currentAnimation = xfacingDirection == 1 ? idleRightAnimation : idleLeftAnimation;
                }
            }
            else startIdleTimer();
        }
        if (newPlayerPos.x - playerPos.x > 0){
            currentAnimation = walkRightAnimation;
            xfacingDirection = 1;
            counting = false;
        }
        if (newPlayerPos.x - playerPos.x < 0){
            currentAnimation = walkLeftAnimation;
            xfacingDirection = -1;
            counting = false;
        }

    }

    /**
     * Starts the idle timer
     */
    private void startIdleTimer(){
        idleTimer = 0.1f;
        counting = true;
    }

    /**
     * Calculates the alpha value for the lerp function
     */
    private float calculateAlpha() {
        currentTime += Gdx.graphics.getDeltaTime();
        return currentTime / moveSpeed;
    }

    /**
     * Animates the player
     * @param animation the tecture region containing the animation frames
     * @return the animation
     */
    private Animation<TextureRegion> animate(TextureRegion[] animation){
        return new Animation<>(0.15f, animation);
    }

    /**
     * Disposes the texture
     */
    public void dispose() {
        texture.dispose();
    }

    /**
     * Gets the player position in the world
     * @return the player position
     */
    public Vector2 getRenderPos(){
        return playerPos;
    }
}
