package com.g16.feyrune.model.overworld.map;

public class Tile {
    private final boolean collision;
    private boolean canEncounter;
    private Transporter transporter;

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
    public void removeEncounter(){
        canEncounter = false;
    }
    public boolean hasTransporter(){
        return transporter != null;
    }
    public Transporter getTransporter() {
        return transporter;
    }
    protected void setTransporter(Transporter transporter) {
        this.transporter = transporter;
    }
}
