package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Transporter {
    private final String mapAssetPath;
    private final Point from;
    private final Point to;

    /**
     * Constructor for the Transporter class
     * @param mapAssetPath the path to the map asset
     * @param from the point where the player will be teleported from
     * @param to the point where the player will be teleported to
     */
    protected Transporter(String mapAssetPath, Point from, Point to) {
        this.mapAssetPath = mapAssetPath;
        this.from = from;
        this.to = to;
    }

    /**
     * Gets the x-coordinate of where the player will be teleported from
     * @return the x-coordinate of where the player will be teleported from
     */
    public int getFromX() {
        return from.x;
    }

    /**
     * Gets the y-coordinate of where the player will be teleported from
     * @return the y-coordinate of where the player will be teleported from
     */
    public int getFromY() {
        return from.y;
    }

    /**
     * Gets the Point where the player will be teleported from
     * @return the Point where the player will be teleported from
     */
    public Point getTransitionFrom() {
        return new Point(from);
    }

    /**
     * Gets the Point where the player will be teleported to
     * @return the Point where the player will be teleported to
     */
    public Point getTransitionTo() {
        return new Point(to);
    }

    /**
     * Gets the path to the map asset
     * @return the path to the map asset
     */
    public String getMapAssetPath() {
        return mapAssetPath;
    }
}
