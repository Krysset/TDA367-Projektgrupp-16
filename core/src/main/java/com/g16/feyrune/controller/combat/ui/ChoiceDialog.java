package com.g16.feyrune.controller.combat.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.controller.combat.CombatInputHandler;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChoiceDialog {
    private List<ChoiceButton> buttons;
    private String spritePath = "/ui/choiceDialog.png";
    private Texture texture;
    private float width = Gdx.graphics.getWidth(), height = Gdx.graphics.getHeight()/4;
    private Point pos = new Point(0-(int)width/2,0-(int)height*2);
    private Camera camera;
    private CombatInputHandler inputHandler;
    private BitmapFont font;

    /**
     * Constructor for the ChoiceDialog class
     * @param inputHandler the inputHandler of the combatController
     */
    public ChoiceDialog(CombatInputHandler inputHandler){ //TODO: Everything from here is coded to work, not look good :)
        this.inputHandler = inputHandler;
        this.camera = new OrthographicCamera(width,height*4);
        String absPath= new File("").getAbsolutePath();

        font = new BitmapFont(Gdx.files.internal(absPath+"/fonts/superAwesomeFont.fnt"),
                Gdx.files.internal(absPath+"/fonts/superAwesomeFont.png"),false);

        texture = new Texture(Gdx.files.internal(absPath+spritePath));

        buttons = new ArrayList<>();
        int bWidth=(int)width/2;
        int midWidth = pos.x+bWidth;
        int bHeight = (int)height/2;
        int midHeight = pos.y+bHeight;
        buttons.add(new ChoiceButton("Attack",  0,    new Vector2(pos.x,      midHeight), bWidth,bHeight, font));
        buttons.add(new ChoiceButton("Monsters",1,   new Vector2(midWidth,   midHeight), bWidth,bHeight, font));
        buttons.add(new ChoiceButton("Items",   2,    new Vector2(pos.x,      pos.y),     bWidth,bHeight, font));
        buttons.add(new ChoiceButton("Flee",    3,   new Vector2(midWidth,   pos.y),     bWidth,bHeight, font));
    }

    /**
     * Draws the ChoiceDialog
     * @param batch the batch to draw on
     */
    public void render(Batch batch){
        batch.setProjectionMatrix(camera.projection);
        batch.draw(texture,pos.x,pos.y,width,height);
        for (ChoiceButton button : buttons) {
            button.render(inputHandler.getCurrentSelection() == button.getButtonSelection(), batch);
        }
    }
}
