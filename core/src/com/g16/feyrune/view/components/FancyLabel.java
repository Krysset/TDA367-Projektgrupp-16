package com.g16.feyrune.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

public class FancyLabel extends Label {

    private String imageString;
    private Image image;
    private LabelStyle style;
    public FancyLabel(Vector2 position, String text, String backgroundImage, int width, int height) {
        this(text, new LabelStyle());
        super.setSize(width, height);
        super.setPosition(position.x, position.y);
        super.setAlignment(Align.center);
        this.imageString = backgroundImage;
        this.image = new Image(new TextureRegion(new Texture(backgroundImage)));

    }
    private FancyLabel(String text, LabelStyle style) {
        super(text, style);
        this.style=style;
        this.style.font = new BitmapFont(Gdx.files.internal("fonts/ShareTechMono-Regular.tff"));
    }

    @Override
    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        image.draw(batch, parentAlpha);
    }
}
