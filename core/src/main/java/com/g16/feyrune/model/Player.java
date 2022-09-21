package com.g16.feyrune.model;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player {
    private String name;
    private Point coordinates;
    private Texture texture;

    public Player(String name, Point coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        texture = new Texture("assets/hero/humanmale/humanMale.png");
    }

    public void move(int deltaX, int deltaY) {
        coordinates.x += deltaX;
        coordinates.y += deltaY;
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
}
