package com.g16.feyrune.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.g16.feyrune.enums.Direction;
import com.g16.feyrune.view.combat.CombatInputHandler;

public class CombatInputProcessor implements IInput {
    private CombatInputHandler inputHandler;

    public CombatInputProcessor(CombatInputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    @Override
    public void setAsInputProcessor(){
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A){
            inputHandler.changeSelection(Direction.LEFT);
        }
        if (keycode == Input.Keys.D){
            inputHandler.changeSelection(Direction.RIGHT);
        }
        if (keycode == Input.Keys.W){
            inputHandler.changeSelection(Direction.UP);
        }
        if (keycode == Input.Keys.S){
            inputHandler.changeSelection(Direction.DOWN);
        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

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
