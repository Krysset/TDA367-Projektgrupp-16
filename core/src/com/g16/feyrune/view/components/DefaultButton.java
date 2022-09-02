package com.g16.feyrune.view.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.g16.feyrune.interfaces.Observer;


public class DefaultButton extends Button {
    private String buttonText;
    private int height;
    private int width;
    private Vector2 position;
    private Observer observer;

    public DefaultButton(String buttonText, int height, int width, Vector2 position, Observer observer) {
        super();
        this.buttonText = buttonText;
        this.height = height;
        this.width = width;
        this.position = position;
        this.observer = observer;
    }

    public void onClick(){
        observer.update();
    }

    }
