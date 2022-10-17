package com.g16.feyrune.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.g16.feyrune.model.overworld.MovementHandler;

public class WorldInputProcessor implements IInput, InputProcessor {
    private MovementHandler movementHandler;

    /**
     * Constructor for the WorldInputProcessor
     * @param movementHandler the movementHandler to control
     */
    public WorldInputProcessor(MovementHandler movementHandler) {
        super();
        this.movementHandler = movementHandler;
    }

    /**
     * Sets the WorldInputProcessor as the active input processor
     */
    @Override
    public void setAsInputProcessor(){
        Gdx.input.setInputProcessor(this);
    }

    /**
     * Checks if the key is pressed and moves the player accordingly
     * @param keycode the key that is pressed
     * @return true if the key is pressed
     */
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

    /**
     * Checks if the key is released and stops the player accordingly
     * @param keycode the key that is released
     * @return true if the key is released
     */
    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A){
            movementHandler.resetXDirection();
        }
        if (keycode == Input.Keys.D){
            movementHandler.resetXDirection();
        }
        if (keycode == Input.Keys.W){
            movementHandler.resetYDirection();
        }
        if (keycode == Input.Keys.S){
            movementHandler.resetYDirection();
        }
        return true;    }

    /**
     * Does nothing
     * @param character The character to check if typed
     * @return false
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * Does nothing
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button the button
     * @return false
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Does nothing
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @param button the button
     * @return false
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Does nothing
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @return false
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * Does nothing
     * @param screenX
     * @param screenY
     * @return false
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Does nothing
     * @param amountX the horizontal scroll amount, negative or positive depending on the direction the wheel was scrolled.
     * @param amountY the vertical scroll amount, negative or positive depending on the direction the wheel was scrolled.
     * @return false
     */
    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
