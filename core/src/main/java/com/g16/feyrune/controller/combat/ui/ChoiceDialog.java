package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.controller.combat.CombatInputHandler;
import com.g16.feyrune.controller.enums.Selection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChoiceDialog {
    private List<ChoiceButton> buttons;
    private String spritePath = "assets/ui/choiceDialog.png";
    private Texture texture;
    private float width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight() / 4;
    private Point pos = new Point(0,0);
    private CombatInputHandler inputHandler;
    private BitmapFont font;

    public ChoiceDialog(CombatInputHandler inputHandler){ //TODO: Everything from here is coded to work, not look good :)
        this.inputHandler = inputHandler;

        font = new BitmapFont(Gdx.files.internal("assets/fonts/superAwesomeFont.fnt"),
                Gdx.files.internal("assets/fonts/superAwesomeFont.png"),false);

        texture = new Texture(Gdx.files.internal(spritePath));

        buttons = new ArrayList<>();
        buttons.add(new ChoiceButton("Attack", Selection.FIRST, new Vector2(pos.x, (pos.y + height/2)),width/2,height/2, font));
        buttons.add(new ChoiceButton("Monsters", Selection.SECOND, new Vector2((int)(pos.x + width/2), (pos.y + height/2)),width/2,height/2, font));
        buttons.add(new ChoiceButton("Items", Selection.THIRD, new Vector2(pos.x, pos.y),width/2,height/2, font));
        buttons.add(new ChoiceButton("Flee", Selection.FOURTH, new Vector2((pos.x + width/2), pos.y),width/2,height/2, font));
    }

    public void render(Batch batch){
        batch.draw(texture,0,0,width,height);
        for (ChoiceButton button : buttons) {
            button.render(inputHandler.getCurrentSelection() == button.getButtonSelection(), batch);
        }
    }
}
