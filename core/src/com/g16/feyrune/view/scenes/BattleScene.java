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

    private void createuiStage(){
        for(int i=1;i<5;i++){
        Button b=new Button(new Vector2(100*i,100),"components/cool.png",null,"knapp"+i);
        uiStage.addActor(b);

        }
    }
    private void createobjectStage(){

    }
    private void createterrainStage(){

    }

    public class test implements Observer{
        @Override
        public void update(String action){
            System.out.println(action);
        }
    }
}
