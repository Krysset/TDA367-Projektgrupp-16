package com.g16.feyrune.view.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.g16.feyrune.interfaces.Observer;

public class Button extends Actor {

    private String image;
    private Vector2 position;
    private TextureRegionDrawable td;
    private ImageButton button;
    private Observer[] observers;

    private String action;

    public Button(Vector2 position, String image, Observer[] observers, String action){
        this.image = image;
        this.position = position;
        this.observers = observers;
        this.action = action;
        createTextureRegionDrawable();
        connectButton();
    }

    private void createTextureRegionDrawable(){
        Texture buttonTexture = new Texture("components/cool.png");
        TextureRegion buttonRegion = new TextureRegion(buttonTexture);
        td = new TextureRegionDrawable(buttonRegion);
        createButton();
    }

    private void createButton(){
        button = new ImageButton(td);
        button.setPosition(position.x, position.y);
    }

    private void connectButton(){
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked");
                for(Observer o : observers){
                    o.update(action);
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        button.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        button.act(delta);
    }
}
