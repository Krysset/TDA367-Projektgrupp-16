package com.g16.feyrune.view;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.controller.Controller;
import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.view.combat.CombatScene;
import com.g16.feyrune.view.overworld.OverworldScene;
import jdk.jfr.internal.tool.PrettyWriter;

import java.util.ArrayList;

public class View implements IObserver {
    private Model model;
    private IScene currentScene;
    private OverworldScene overworldScene;
    private CombatScene combatScene;
    private SpriteBatch batch;

    public View(Model model){
        this.model = model;
        this.model.registerNewObserver(this);


        batch = new SpriteBatch();
        overworldScene = new OverworldScene(model.getPlayer(), batch);
        combatScene = new CombatScene(batch);

        update(); //TODO: this is also wrong and bad :)
    }

    public void update(){
        ModelState currentModelState = model.getCurrentModelState();
        changeScene(currentModelState);
        currentScene.update();
    }

    public void render(){
        currentScene.render();
    }


    public SpriteBatch getBatch(){
        return batch;
    }

    private void changeScene(ModelState state) {
        switch (state){
            case WORLD:
                currentScene = overworldScene;
                break;
            case COMBAT:
                currentScene = combatScene;
                break;
        }
    }

    public CombatScene getCombatScene(){
        return combatScene;
    }

    private void setOverWorldAsScene(){
    }
    private void setCombatAsScene(){
        //combatScene.renderNewCombat(); //TODO: THIS IS WHERE WE START A NEW COMBAT
    }
}
