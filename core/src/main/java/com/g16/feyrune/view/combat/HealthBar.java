package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.controller.enums.Selection;

public class HealthBar {
    private double maxHealth;
    private String spritePath = "assets/ui/choiceDialog.png"; //TODO: temp
    private float originalWidth,width,height,posX,posY;
    private Texture texture;
    public HealthBar(double maxHealth, float posX, float posY, float width, float height){
        this.maxHealth = maxHealth;
        this.height = height;
        this.width = width;
        originalWidth = width;
        this.posX = posX;
        this.posY = posY;
        texture = new Texture(Gdx.files.internal(spritePath));
    }

    public void setCurrentHealth(double currentHealth) {
        width = (float) (currentHealth / maxHealth) * originalWidth;
    }



    public void render(Batch batch){
        batch.draw(texture,posX,posY,originalWidth,height);
        batch.setColor(0,1,0,1);
        batch.draw(texture,posX,posY,width,height);
        batch.setColor(1,1,1,1);
    }
}
