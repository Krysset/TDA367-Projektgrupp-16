package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.creatures.CombatCreature;
import com.g16.feyrune.model.creature.BaseCreature;
import com.g16.feyrune.view.utils.AnimationUtils;

public class CreatureRenderer {
    private CombatCreature creature;
    private String spritePath = "assets/entities/bandit/bandit.png"; //TODO: temp
    private float width,height,posX,posY;
    private Texture texture;
    private TextureRegion[] animationRegion;
    private float stateTime = 0;
    private boolean flip;

    /**
     * Constructor for the CreatureRenderer
     * @param creature the creature to render
     * @param posX the x position of said creature
     * @param posY the y position of said creature
     * @param flip whether the creature should be flipped or not (for the enemy)
     */
    public CreatureRenderer(CombatCreature creature, float posX, float posY, boolean flip){
        this.creature = creature;
        this.posX = posX;
        this.posY = posY;
        this.flip = flip;
        try {
            String creatureName = creature.getName();
            this.spritePath = "assets/entities/"+creatureName+"/"+creatureName+".png";
            texture = new Texture(Gdx.files.internal(spritePath));
        }catch (Exception e){
            texture = new Texture(Gdx.files.internal("assets/entities/bandit/bandit.png"));
        }


        animationRegion = AnimationUtils.getAnimationFrames(texture,8,6,4,flip? 4: 0);

        width = (texture.getWidth() + texture.getWidth() * creature.getPower()/100);
        height = (texture.getHeight() + texture.getHeight() * creature.getPower()/100);
    }


    /**
     * Renders the creature
     * @param batch the batch to render on
     */
    public void render(Batch batch){

        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        Animation<TextureRegion> animation = animate(animationRegion);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);

        batch.draw(currentFrame, posX - (flip? width : 0), posY, width , height);


        //TODO: NOT IMPLEMENTED
    }

    /**
     * Animates the creature
     * @param animation The texture region to use for animation
     * @return the animation
     */
    private Animation<TextureRegion> animate(TextureRegion[] animation){
        return new Animation<>(0.15f, animation);
    }


}
