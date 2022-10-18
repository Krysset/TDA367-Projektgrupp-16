package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Tile {
    private final boolean collision;
    private boolean canEncounter;
    private Transporter transporter;

    /**
     * Constructor for the tile
     * @param collision True if the tile is a collision tile, false otherwise
     */
    public Tile(boolean collision) {
        this.collision = collision;
        this.canEncounter = false;
    }

    /**
     * Returns true if the tile is a collision tile, false otherwise
     * @return true if the tile is a collision tile, false otherwise
     */
    public boolean isCollision() {
        return collision;
    }

    /**
     * Returns true if the tile can contain an encounter, false otherwise
     * @return true if the tile can contain an encounter, false otherwise
     */
    public boolean canEncounter() {
        return canEncounter;
    }

    /**
     * Returns whether the tile contains a transporter
     * @return true if the tile contains a transporter, false otherwise
     */
    public boolean hasTransporter(){
        return transporter != null;
    }

    /**
     * Returns the transporter connected to the tile.
     * @return the transporter connected to the tile.
     */
    public Transporter getTransporter() {
        return transporter;
    }

    /**
     * 
     * @param transporter
     */
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
