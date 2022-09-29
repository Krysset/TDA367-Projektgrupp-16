package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.view.utils.Image;

public class HealthBar {
    private double maxHealth, currentHealth;
    private String spritePath = "assets/ui/choiceDialog.png";
    private Vector2 pos = new Vector2();
    private float width, height;
    private float oWidth;

    private Texture outlineTexture;
    private Texture healthIndicatorTexture;


    public HealthBar(double maxHealth, float posX, float posY, float width, float height){
        this.maxHealth = maxHealth;
        currentHealth = maxHealth;
        pos.x = posX;
        pos.y = posY;
        this.oWidth = width;
        this.height = height;
        outlineTexture = new Texture(Gdx.files.internal(spritePath));
        outlineTexture = Image.resize(outlineTexture, 1, 0.5f);
        healthIndicatorTexture = new Texture(Gdx.files.internal(spritePath));
        healthIndicatorTexture = Image.resize(healthIndicatorTexture, 1, 0.5f);
        setCurrentHealth(currentHealth);
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
        width = (float) (oWidth * currentHealth/maxHealth);
    }

    public void render(Batch batch){
        batch.draw(outlineTexture, pos.x,pos.y,oWidth,height);
        batch.setColor(0,1,0,1);
        batch.draw(healthIndicatorTexture,pos.x,pos.y,width,height);
        batch.setColor(1,1,1,1);
    }

    public double getCurrentHealth(){
        return currentHealth;
    }
}
