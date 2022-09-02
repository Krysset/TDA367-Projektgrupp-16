package com.g16.feyrune.view.textureMap;

public class TextureTile {
    private float x, y;
    private int gid;

    public TextureTile(float x, float y, int gid) {
        this.x = x;
        this.y = y;
        this.gid = gid;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getGid() {
        return gid;
    }
}
