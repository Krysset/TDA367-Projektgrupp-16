package com.g16.feyrune.map;

public class Tile {
    private final boolean collision;
    private final boolean canEncounter;
    private final String path;

    public Tile(boolean collision, boolean canEncounter, String path) {

        this.collision = collision;
        this.canEncounter = canEncounter;
        this.path = path;
    }

    public boolean hasCollision() {
        return collision;
    }

    public boolean canEncounter() {
        return canEncounter;
    }
}
