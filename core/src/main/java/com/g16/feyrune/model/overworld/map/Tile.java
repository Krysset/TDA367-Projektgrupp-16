package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Tile {
    private final boolean collision;
    private boolean canEncounter;
    private Transporter transporter;

    public Tile(boolean collision) {
        this.collision = collision;
        this.canEncounter = false;
    }

    public boolean isCollision() {
        return collision;
    }

    public boolean canEncounter() {
        return canEncounter;
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
    protected void setCanEncounter(boolean canEncounter) {
        this.canEncounter = canEncounter;
    }
    protected Point getTransportCoordinates(){
        return transporter.getTransitionTo();
    }

    protected String getTransportMapAssetPath(){
        return transporter.getMapAssetPath();
    }
}
