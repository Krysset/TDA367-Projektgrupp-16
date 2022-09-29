package com.g16.feyrune.controller.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.controller.IInput;

public class CombatInputProcessor implements IInput, InputProcessor {
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
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
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
        if (keycode == Input.Keys.ENTER){
            inputHandler.excecuteSelection();
        }
        return true;
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
