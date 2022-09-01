package com.g16.feyrune.map;

public class Tile {
    private final boolean collision;
    private final boolean canEncounter;

    public Tile(boolean collision, boolean canEncounter) {
        this.collision = collision;
        this.canEncounter = canEncounter;
    }

    public boolean hasCollision() {
        return collision;
    }

    public boolean canEncounter() {
        return canEncounter;
    }
}
