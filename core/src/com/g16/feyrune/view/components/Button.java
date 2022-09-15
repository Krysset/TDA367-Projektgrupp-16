package com.g16.feyrune.view.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.g16.feyrune.interfaces.Observer;

public class Button extends ImageButton {

    private String image;
    private Vector2 position;
    private TextureRegionDrawable td;
    private ImageButton button;
    private Observer[] observers;
    private String action;
    public Button(Vector2 position, String image, Observer[] observers, String action){
        this(new TextureRegionDrawable(new TextureRegion(new Texture(image))), position, image, observers, action);
    }
    private Button(TextureRegionDrawable d, Vector2 position, String image, Observer[] observers, String action){
        super(d);
        this.image = image;
        this.position = position;
        this.observers = observers;
        this.action = action;
        connectButton();
    }
    private void connectButton(){
        super.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked");
                for(Observer o : observers){
                    o.update();
                }
            }
        });
    }
}