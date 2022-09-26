package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.controller.enums.Selection;
import com.g16.feyrune.view.utils.Image;

import java.util.List;

public class ChoiceDialog {
    private Selection currentSelection;
    private List<ChoiceButton> buttons;
    private String spritePath = "assets/ui/choiceDialog.png";
    private TextureRegion textureRegion;
    private Texture texture;

    public ChoiceDialog(){ //TODO: there should be some logic here to select one of them
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
        texture = new Texture(Gdx.files.internal(spritePath));
        textureRegion = new TextureRegion(texture, )
    }

    public void render(Batch batch){

        for (ChoiceButton button : buttons) {
            button.render(false);
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
    public Selection getCurrentSelection(){
        return currentSelection;
    }
}
