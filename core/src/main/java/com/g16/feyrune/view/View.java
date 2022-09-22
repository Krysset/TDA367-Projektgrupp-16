package com.g16.feyrune.view;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.enums.ModelState;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.view.overworld.OverworldScene;

public class View {
    private Model model;
    private ModelState currentState;
    private IScene currentScene;
    private OverworldScene overworldScene;
    private SpriteBatch batch;
    private Camera camera;

    public void View(Model model){
        this.model = model;
        currentState = model.getCurrentModelState();
        overworldScene = new OverworldScene(model.getPlayer(),batch,camera);
    }

    public void update(){

    }

    public void render(){
        currentScene.render();
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
}

