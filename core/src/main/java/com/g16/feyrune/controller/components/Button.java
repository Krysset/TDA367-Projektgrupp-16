package com.g16.feyrune.controller.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.g16.feyrune.interfaces.IObserver;

public class Button extends ImageButton {
    private String image;
    private Vector2 position;
    private TextureRegionDrawable td;
    private ImageButton button;
    private IObserver[] IObservers;
    private String action;
    public Button(Vector2 position, String image, IObserver[] IObservers, String action){
        this(new TextureRegionDrawable(new TextureRegion(new Texture(image))), position, image, IObservers, action);
    }
    private Button(TextureRegionDrawable d, Vector2 position, String image, IObserver[] IObservers, String action){
        super(d);
        this.image = image;
        this.position = position;
        this.IObservers = IObservers;
        this.action = action;
        connectButton();
    }
    private void connectButton(){
        super.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked");
                for(IObserver o : IObservers){
                    o.update();
                }
            }
        });
    }
}