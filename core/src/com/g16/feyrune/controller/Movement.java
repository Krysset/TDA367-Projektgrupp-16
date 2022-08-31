package com.g16.feyrune.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Movement {

    // currentDirection goes between -1 and 1
    public int currentXDirection = 0;
    public int currentYDirection = 0;

    public void Initialize(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.A){
                    currentXDirection += -1;
                }
                if (keycode == Input.Keys.D){
                    currentXDirection += 1;
                }
                if (keycode == Input.Keys.W){
                    currentYDirection += -1;
                }
                if (keycode == Input.Keys.S){
                    currentYDirection += 1;
                }
                currentXDirection = Math.max(Math.min(currentXDirection,1),-1);
                currentYDirection = Math.max(Math.min(currentYDirection,1),-1);
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.A){
                    currentXDirection += 1;
                }
                if (keycode == Input.Keys.D){
                    currentXDirection += -1;
                }
                if (keycode == Input.Keys.W){
                    currentYDirection += 1;
                }
                if (keycode == Input.Keys.S){
                    currentYDirection += -1;
                }
                return true;
            }
        });
    }
}
