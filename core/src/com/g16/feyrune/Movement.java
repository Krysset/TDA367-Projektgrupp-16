package com.g16.feyrune;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Movement {
   public enum XDirection {
        LEFT,RIGHT,NONE;
    }
    public enum YDirection {
        UP,DOWN,NONE;
    }

    public XDirection currentXDirection = XDirection.NONE;
    public YDirection currentYDirection = YDirection.NONE;

    public void setCurrentXDirection(XDirection direction) {
        if (currentXDirection == XDirection.NONE || currentXDirection == direction){
            currentXDirection = direction;
        }
        else {
            currentXDirection = XDirection.NONE;
        }
    }

    public void setCurrentYDirection(YDirection direction) {
        if (currentYDirection == YDirection.NONE || currentYDirection == direction){
            currentYDirection = direction;
        }
        else {
            currentYDirection = YDirection.NONE;
        }
    }

    public void Initialize(){
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                switch (keycode){
                    case Input.Keys.A:
                        setCurrentXDirection(XDirection.LEFT);
                        break;
                    case Input.Keys.W:
                        setCurrentYDirection(YDirection.UP);
                        break;
                    case Input.Keys.D:
                        setCurrentXDirection(XDirection.RIGHT);
                        break;
                    case Input.Keys.S:
                        setCurrentYDirection(YDirection.DOWN);
                        break;
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                switch (keycode){
                    case Input.Keys.A:
                    case Input.Keys.D:
                        setCurrentXDirection(XDirection.NONE);
                        break;
                    case Input.Keys.W:
                    case Input.Keys.S:
                        setCurrentYDirection(YDirection.NONE);
                        break;
                }
                return true;
            }
        });
    }
}
