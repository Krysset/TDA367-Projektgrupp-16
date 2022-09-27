package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.g16.feyrune.controller.enums.Selection;

import java.awt.*;

public class ChoiceButton {
    private String name;
    private Selection buttonSelection;
    private String spritePath = "assets/ui/choiceDialog.png";
    private Point pos;
    private Texture texture;
    private float width,height;
    private BitmapFont font;

    public ChoiceButton(String name, Selection selection, Point pos, float width, float height){
        this.name = name;
        this.buttonSelection = selection;
        this.pos = pos;
        this.width = width;
        this.height = height;
        texture = new Texture(Gdx.files.internal(spritePath));
        font = new BitmapFont(Gdx.files.internal("assets/fonts/superAwesomeFont.fnt"),
                Gdx.files.internal("assets/fonts/superAwesomeFont.png"),false);
    }
    public void render(boolean isSelected, Batch batch){
        //TODO: NOT IMPLEMENTED graphics nor logic for this object;
        if(isSelected) batch.setColor(1,0,0,1);
        batch.draw(texture,pos.x,pos.y,width,height);
        font.draw(batch,name, pos.x + width / 2 - font.getSpaceXadvance() * name.length()/2, pos.y + height / 2 + font.getCapHeight()/2);
        batch.setColor(1,1,1,1);
    }

    public Selection getButtonSelection(){
        return buttonSelection;
    }
}
