package com.g16.feyrune.view.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.g16.feyrune.interfaces.Observer;

public class BattleScene extends Scene{

    private Observer[] observers;

    public BattleScene(int viewWidth, int viewHeight, Observer[] observers) {
        super(viewWidth, viewHeight, new Stage(new FitViewport(viewWidth,viewHeight)), new Stage(new FitViewport(viewWidth,viewHeight)), new Stage(new FitViewport(viewWidth,viewHeight)));
        this.observers = observers;
        createuiStage();
        createobjectStage();
        createterrainStage();
    }

    private void createuiStage(){
        ImageButton b = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("components/cool.png"))));
        b.setPosition(100, 100);
        b.addListener(new ClickListener() {
                          @Override
                          public void clicked(InputEvent event, float x, float y) {
                              System.out.println("hej2");
                              for(Observer o : observers){
                                  o.update();
                              }
                          }
                      }
        );
        uiStage.addActor(b);
    }
    private void createobjectStage(){

    }
    private void createterrainStage(){

    }
}
