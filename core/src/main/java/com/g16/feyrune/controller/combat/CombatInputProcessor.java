package com.g16.feyrune.controller.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.g16.feyrune.controller.IInput;
import com.g16.feyrune.controller.enums.Direction;

public class CombatInputProcessor implements IInput, InputProcessor {
    private final CombatInputHandler inputHandler;

    /**
     * Constructor for the input processor
     * @param inputHandler the input handler
     */
    public CombatInputProcessor(CombatInputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    /**
     * Sets CombatInputProcessor as the active input processor
     */
    @Override
    public void setAsInputProcessor(){
        Gdx.input.setInputProcessor(this);
    }

    /**
     *
     * @param keycode the keycode of the key to be checked if stopped being pressed
     * @return if the key is no longer being pressed
     */
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    /**
     *
     * @param keycode the keycode of the key to be checked if being pressed
     * @return if the key is being pressed
     */
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

    /**
     *
     * @param character the character to be checked if being typed
     * @return if the character is being typed
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     *
     * @param screenX the x coordinate of the mouse
     * @param screenY the y coordinate of the mouse
     * @param pointer the pointer of the mouse
     * @param button the button of the mouse
     * @return if the mouse is being clicked down in point (screenX, screenY)
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     *
     * @param screenX the x coordinate of the mouse
     * @param screenY the y coordinate of the mouse
     * @param pointer the pointer of the mouse
     * @return if the mouse is stopped being pressed in point (screenX, screenY)
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     *
     * @param screenX the x coordinate of the mouse
     * @param screenY the y coordinate of the mouse
     * @return if the mouse is being dragged in point (screenX, screenY)
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     *
     * @param screenX the x coordinate of the mouse
     * @param screenY the y coordinate of the mouse
     * @return if the mouse is being moved in point (screenX, screenY)
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     *
     * @param amountX the amount of scrolling in X-direction
     * @param amountY the amount of scrolling in Y-direction
     * @return if the mouse is being scrolled
     */
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
