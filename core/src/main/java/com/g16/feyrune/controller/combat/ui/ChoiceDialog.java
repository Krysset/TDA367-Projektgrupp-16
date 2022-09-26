package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.controller.combat.CombatInputHandler;
import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.controller.enums.Selection;
import com.g16.feyrune.view.utils.Image;

import java.awt.*;
import java.util.List;

public class ChoiceDialog {
    private List<ChoiceButton> buttons;
    private String spritePath = "assets/ui/choiceDialog.png";
    private TextureRegion textureRegion;
    private Texture texture;
    private float width = 50, height = 20;
    private Point pos = new Point(10,0);
    private CombatInputHandler inputHandler;

    public ChoiceDialog(CombatInputHandler inputHandler){ //TODO: Everything from here is coded to work, not look good :)
        this.inputHandler = inputHandler;

        buttons.add(new ChoiceButton("Attack", Selection.FIRST, new Point(pos.x, (int)(pos.y + height/2)),height/2,height/2));
        buttons.add(new ChoiceButton("Monsters", Selection.SECOND, new Point((int)(pos.x + width/2), (int)(pos.y + height/2)),height/2,height/2));
        buttons.add(new ChoiceButton("Items", Selection.THIRD, new Point(pos.x, pos.y),height/2,height/2));
        buttons.add(new ChoiceButton("Flee", Selection.FOURTH, new Point((int)(pos.x + width/2), pos.y),height/2,height/2));
        texture = new Texture(Gdx.files.internal(spritePath));
    }

    public void render(Batch batch){
        batch.draw(texture,10,0,50,20); //TODO: change theese hardcoded numbers


        for (ChoiceButton button : buttons) {
            button.render(inputHandler.getCurrentSelection() == button.getButtonSelection(), batch);
        }
    }

    public void changeSelection(Direction direction){ //TODO: NOT IMPLEMENTED LOGIC, should have some relation to controller..
        switch (direction){
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
            case BACK:

        }

    }
}
