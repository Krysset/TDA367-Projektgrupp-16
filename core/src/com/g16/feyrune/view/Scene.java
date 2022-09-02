package com.g16.feyrune.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class Scene implements Screen {
    protected Game game;
    protected Stage mainStage;
    protected Stage uiStage;
    public final int viewWidth;
    public final int viewHeight;
    protected boolean paused;

    public Scene(Game game, int viewWidth, int viewHeight) {
        this.game = game;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        paused = false;
        mainStage = new Stage(new FitViewport(viewWidth, viewHeight));
        uiStage = new Stage(new FitViewport(viewWidth, viewHeight));
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
            mainStage.act(dt);
            update(dt);
        }
        mainStage.draw();
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
