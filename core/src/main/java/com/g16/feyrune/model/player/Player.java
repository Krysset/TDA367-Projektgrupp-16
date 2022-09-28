package com.g16.feyrune.model.player;

import com.badlogic.gdx.graphics.Texture;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.interfaces.IObserver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Point coordinates;
    private Texture texture;
    private ICreature creature; //TODO: this is wrong and temp
    private List<IObserver> observers;

    public Player(String name, Point coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        texture = new Texture("assets/hero/humanmale/humanMale.png");
        this.observers = new ArrayList<>();
    }

    public void move(int deltaX, int deltaY) {
        coordinates.x += deltaX;
        coordinates.y += deltaY;
        notifyObservers();
    }

    public void setPosition(int newPosX, int newPosY) {
        coordinates.x = newPosX;
        coordinates.y = newPosY;
    }

    public Point getCoordinates() {
        return new Point(coordinates);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Texture getTexture() {
        return texture;
    }

    //TODO: This is wrong and temp
    public ICreature getCreature(){
        return creature;
    }

    private void notifyObservers() {
        for (IObserver observer : observers) {
            observer.observerUpdate();
        }
    }
}
