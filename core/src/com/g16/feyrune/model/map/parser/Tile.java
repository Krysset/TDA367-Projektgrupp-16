package com.g16.feyrune.model.map.parser;

public class Tile {
    private final boolean collision;
    private final boolean canEncounter;
    private final int[] gIds;

    public Tile(int[] gIds, boolean collision, boolean canEncounter) {
        this.gIds = gIds;
        this.collision = collision;
        this.canEncounter = canEncounter;
    }

    public boolean isCollision() {
        return collision;
    }

    public int[] getgIds() {
        return gIds;
    }

    public boolean hasCollision() {
        return collision;
    }

    public boolean canEncounter() {
        return canEncounter;
    }

    @Override
    public String toString() {
        String prt = "";
        for (int gId:gIds) {
            prt += " " + gId;
        }
        return (prt + "-" + (collision ? 1 : 0));
    }
}
