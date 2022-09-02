package com.g16.feyrune.view.scenes;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class Scene implements Screen {
    protected Stage terrainStage;
    protected Stage objectStage;
    protected Stage uiStage;
    protected int viewWidth;
    protected int viewHeight;
    protected boolean paused;

    public Scene( int viewWidth, int viewHeight, Stage uiStage, Stage objectStage, Stage terrainStage) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        paused = false;
        this.uiStage = uiStage;
        this.objectStage = objectStage;
        this.terrainStage = terrainStage;

        FitViewport viewport = new FitViewport(viewWidth, viewHeight);

        this.uiStage.setViewport(viewport);
        this.objectStage.setViewport(viewport);
        this.terrainStage.setViewport(viewport);
    }

    private void update(float dt){

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float dt){
        uiStage.act(dt);
        if (!paused) {
            objectStage.act(dt);
            terrainStage.act(dt);
            update(dt);
        }
        objectStage.draw();
        uiStage.draw();
        terrainStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        return;
    }

    @Override
    public void pause() {
        paused = true;
    }

    @Override
    public void resume() {
        paused = false;
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
