package com.g16.feyrune.map;

public class Tile {
    private final boolean collision;
    private final boolean canEncounter;
    private final int gId;

    public Tile(int gId, boolean collision, boolean canEncounter) {
        this.gId = gId;
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
