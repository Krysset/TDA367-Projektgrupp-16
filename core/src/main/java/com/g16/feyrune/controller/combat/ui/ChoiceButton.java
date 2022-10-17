package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.controller.enums.Selection;


public class ChoiceButton {
    private String name;
    private Selection buttonSelection;
    private String spritePath = "assets/ui/choiceDialog.png"; //TODO: temp
    private Vector2 pos;
    private Texture texture;
    private float width,height;
    private BitmapFont font;

    /**
     *
     * @param name What text the button should display
     * @param selection What selection the button should return
     * @param pos Where the button should be placed
     * @param width How wide the button should be
     * @param height How tall the button should be
     * @param font What font the button name should be displayed using
     */
    public ChoiceButton(String name, Selection selection, Vector2 pos, float width, float height, BitmapFont font){
        this.name = name;
        this.buttonSelection = selection;
        this.pos = pos;
        this.width = width;
        this.height = height;
        this.font = font;
        texture = new Texture(Gdx.files.internal(spritePath));

    }

    /**
     * Draws the button
     * @param isSelected Whether the button is selected or not
     * @param batch The batch to draw the button on
     */
    public void render(boolean isSelected, Batch batch){
        if(isSelected) batch.setColor(1,0,0,1);
        batch.draw(texture,pos.x,pos.y,width,height);
        font.draw(batch,name, pos.x + width / 2 - font.getSpaceXadvance() * name.length()/2, pos.y + height / 2 + font.getCapHeight()/2);
        batch.setColor(1,1,1,1);
    }

    /**
     * Returns the selection of the button
     * @return The selection of the button
     */
    public Selection getButtonSelection(){
        return buttonSelection;
    }
}
