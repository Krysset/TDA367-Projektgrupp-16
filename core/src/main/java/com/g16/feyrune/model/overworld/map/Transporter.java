package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Transporter {
    private final String mapAssetPath;
    private final Point from;
    private final Point to;

    protected Transporter(String mapAssetPath, Point from, Point to) {
        this.mapAssetPath = mapAssetPath;
        this.from = from;
        this.to = to;
    }

    public int getFromX() {
        return from.x;
    }

    public int getFromY() {
        return from.y;
    }

    public Point getTransitionTo() {
        return new Point(to);
    }

    public String getMapAssetPath() {
        return mapAssetPath;
    }
}
