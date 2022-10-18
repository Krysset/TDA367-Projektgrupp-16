package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class HealthBar {
    private double maxHealth;
    private String spritePath = "assets/ui/choiceDialog.png"; //TODO: temp
    private float originalWidth,width,height,posX,posY;
    private Texture texture;

    /**
     * Constructor for the HealthBar
     * @param maxHealth the max health of the creature
     * @param posX the x position of the health bar
     * @param posY the y position of the health bar
     * @param width the width of the health bar
     * @param height the height of the health bar
     */
    public HealthBar(double maxHealth, float posX, float posY, float width, float height){
        this.maxHealth = maxHealth;
        this.height = height;
        this.width = width;
        originalWidth = width;
        this.posX = posX;
        this.posY = posY;
        texture = new Texture(Gdx.files.internal(spritePath));
    }

    /**
     * Changes how full the health bar is
     * @param currentHealth the current health of the creature
     */
    public void setCurrentHealth(double currentHealth) {
        width = (float) (currentHealth / maxHealth) * originalWidth;
    }


    /**
     * Renders the health bar
     * @param batch the batch to render on
     */
    public void render(Batch batch){
        batch.draw(texture,posX,posY,originalWidth,height);
        batch.setColor(0,1,0,1);
        batch.draw(texture,posX,posY,width,height);
        batch.setColor(1,1,1,1);
    }
}
