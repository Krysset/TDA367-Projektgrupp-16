package com.g16.feyrune.model.overworld.map;

public class Tile {
    private final boolean collision;
    private final boolean canEncounter;

    public Tile(boolean collision, boolean canEncounter) {
        this.collision = collision;
        this.canEncounter = canEncounter;
    }

    public boolean isCollision() {
        return collision;
    }

    public boolean canEncounter() {
        return canEncounter;
    }
}
