package com.g16.feyrune.view.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.g16.feyrune.interfaces.Observer;
import com.g16.feyrune.view.components.Button;
import com.g16.feyrune.view.components.LabelWithBackground;

public class BattleScene extends Scene{

    private Observer[] observers;

    public BattleScene(int viewWidth, int viewHeight, Observer[] observers) {
        super(viewWidth, viewHeight, new Stage(new FitViewport(viewWidth,viewHeight)), new Stage(new FitViewport(viewWidth,viewHeight)), new Stage(new FitViewport(viewWidth,viewHeight)));
        this.observers = observers;
        createuiStage();
        createobjectStage();
        createterrainStage();
        Gdx.input.setInputProcessor(uiStage);
    }

    private void createuiStage() {
        ImageButton bu = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("components/cool.png"))));
        bu.setPosition(400,400);
        bu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Button clicked");
                }
        });
        uiStage.addActor(bu);

        for(int i=1; i<6; i++){
            Button b = new Button(new Vector2(100*i,200),"components/cool.png", observers,"button"+i );
            uiStage.addActor(b);
        }
        LabelWithBackground fl=new LabelWithBackground(new Vector2(600,600),"Hello","components/cool.png",100,100);
        uiStage.addActor(fl);
    }
    private void createobjectStage(){}
    private void createterrainStage(){}

}
