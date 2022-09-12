package com.g16.feyrune.view.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
        terrainStage.draw();
        objectStage.draw();
        uiStage.draw();
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
