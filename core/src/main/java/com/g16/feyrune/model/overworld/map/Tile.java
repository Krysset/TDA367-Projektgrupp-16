package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Tile {
    private final boolean hasCollision;
    private boolean canEncounter;
    private Transporter transporter;

    public Tile(boolean hasCollision, boolean canEncounter) {
        this.hasCollision = hasCollision;
        this.canEncounter = canEncounter;
    }
    public Tile(boolean hasCollision) {
        this(hasCollision, false);
    }
    public Tile() {
        this(false, false);
    }

    public boolean hasCollision() {
        return hasCollision;
    }

    public boolean canEncounter() {
        return canEncounter;
    }
    public boolean hasTransporter(){
        return transporter != null;
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
