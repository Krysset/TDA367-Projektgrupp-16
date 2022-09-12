package com.g16.feyrune.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class LabelWithBackground extends Actor {

    private String imageString;
    private Image image;
    private LabelStyle style;
    private Label label;

    private String text;
    public LabelWithBackground(Vector2 position, String text, String backgroundImage, int width, int height) {
        this.imageString = backgroundImage;
        this.text = text;
        style= new LabelStyle();
        style.font = new BitmapFont(Gdx.files.internal("fonts/superAwesomeFont.fnt"));
        label = new Label(this.text, style);
        image = new Image(new TextureRegion(new Texture("components/cool.png")));
        image.setPosition(position.x,position.y);
        image.setSize(width,height);
        label.setPosition(position.x,position.y);
        label.setSize(width,height);

    }


    @Override
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float parentAlpha) {
        image.draw(batch, parentAlpha);
        label.draw(batch,parentAlpha);
    }
}
