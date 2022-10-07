package com.g16.feyrune.model.overworld.map;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapManager {
    private Map map;
    private final List<IMapObserver> observers;

    public MapManager(String mapFilePath) {
        this.map = MapParser.parseMapFile(mapFilePath);
        this.observers = new ArrayList<>();
    }

    public MapManager() {
        this("assets/maps/plains1.tmx");
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

    public void useTransporter(Point transporterPos) {
        // Get transporter data for the given position
        String mapAssetPath = map.getTransportMapAssetPath(transporterPos);
        Point transportCoordinates = map.getTransportCoordinates(transporterPos);

        // Load the new map, and update the player starting position
        map = MapParser.parseMapFile(mapAssetPath);
        map.setStartPos(transportCoordinates);

        // Notify observers
        notifyMapObservers(mapAssetPath);
    }

    public boolean hasCollision(int x, int y) {
        return map.hasCollision(x, y);
    }

    public void subscribeMapObserver(IMapObserver observer) {
        observers.add(observer);
    }

    private void notifyMapObservers(String mapAssetPath) {
        for (IMapObserver observer : observers) {
            observer.updateMap(mapAssetPath);
        }
    }

    public void changeMap(String path) {
        map = MapParser.parseMapFile(path);
        notifyMapObservers(path);
    }
}
