package com.g16.feyrune.view.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
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
        test[] t= new test[1];
        for(int i=1;i<5;i++){
        Button b=new Button(new Vector2(100*i,100),"components/cool.png",t,"knapp"+i);
        uiStage.addActor(b);

        }

        Button b=new Button(new Vector2(100,600),"components/cool.png",t,"knapp tre");
        uiStage.addActor(b);
    }
    private void createobjectStage(){
        // Load sprites and different objects
    }
    private void createterrainStage(){
        // Load the background
    }

    public class test implements Observer{
        @Override
        public void update(String action){
            System.out.println(action);
        }
    }
}
