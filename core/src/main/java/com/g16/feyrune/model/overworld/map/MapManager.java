package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class MapManager {
    private Map map;
    private Iterable<IMapObserver> observers;

    public MapManager() {
        this.map = MapParser.parseMapFile("assets/maps/plains1.tmx");
    }

    public int getWidth() {
        return map.getWidth();
    }

    public int getHeight() {
        return map.getHeight();
    }

    public boolean tryEncounter(Point playerPos) {
        return map.tryEncounter(playerPos);
    }

    public void removeEncounterFromTile(Point tilePos) {
        map.removeEncounterFromTile(tilePos);
    }

    public String getTerrainType() {
        return map.getTerrainType();
    }

    public int getStartPosX() {
        return map.getStartPosX();
    }

    public int getStartPosY() {
        return map.getStartPosY();
    }

    public boolean hasTransporter(Point playerPos) {
        return map.hasTransporter(playerPos);
    }

    public boolean isCollision(int x, int y) {
        return map.isCollision(x, y);
    }
}
