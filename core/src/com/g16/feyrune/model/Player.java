package com.g16.feyrune.model;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    private String name;
    private int posX;
    private int posY;

    private Texture texture;

    public Player(String name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        texture = new Texture("assets/hero/humanmale/humanMale.png");
    }

    public void move(int x, int y) {
        if (x < -1 || 1 < x) {
            throw new RuntimeException("Invalid value of x. Expected -1 to 1 but got " + x);
        }
        if (y < -1 || 1 < y) {
            throw new RuntimeException("Invalid value of x. Expected -1 to 1 but got " + y);
        }
        posX += x;
        posY += y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Texture getTexture() {
        return texture;
    }
}
