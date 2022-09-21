package com.g16.feyrune.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.g16.feyrune.model.map.MovementHandler;

public class MapPlayerInputProcessor implements InputProcessor {
    private MovementHandler movementHandler;

    public MapPlayerInputProcessor(MovementHandler movementHandler) {
        super();
        this.movementHandler = movementHandler;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A){
            movementHandler.decreaseXDirection();
        }
        if (keycode == Input.Keys.D){
            movementHandler.increaseXDirection();
        }
        if (keycode == Input.Keys.W){
            movementHandler.increaseYDirection();
        }
        if (keycode == Input.Keys.S){
            movementHandler.decreaseYDirection();
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A){
            movementHandler.increaseXDirection();
        }
        if (keycode == Input.Keys.D){
            movementHandler.decreaseXDirection();
        }
        if (keycode == Input.Keys.W){
            movementHandler.decreaseYDirection();
        }
        if (keycode == Input.Keys.S){
            movementHandler.increaseYDirection();
        }
        return true;    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
