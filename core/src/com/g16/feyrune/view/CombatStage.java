package com.g16.feyrune.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CombatStage extends Stage {
    ImageButton attackButton;
    public CombatStage() {
        super();
        Texture buttonTexture=new Texture("assets/components/cool.png");
        TextureRegion buttonRegion=new TextureRegion(buttonTexture);
        TextureRegionDrawable buttonDrawable=new TextureRegionDrawable(buttonRegion);
        attackButton= new ImageButton(buttonDrawable);

    }

    @Override
    public void draw() {
        super.draw();
        attackButton.draw(this.getBatch(),1);
    }
}
