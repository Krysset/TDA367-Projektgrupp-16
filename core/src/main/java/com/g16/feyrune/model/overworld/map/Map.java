package com.g16.feyrune.model.overworld.map;

import java.awt.*;

public class Map {
    private final Tile[][] tiles;
    private final String terrainType;
    private final int width;
    private final int height;
    private int startPosX;
    private int startPosY;

    /**
     * Constructor for the map
     * @param name Name of the map
     * @param tiles The tiles of the map
     * @param startPosX The starting position of the player on the x-axis
     * @param startPosY The starting position of the player on the y-axis
     */
    protected Map(String name, Tile[][] tiles, int startPosX, int startPosY) {
        this.terrainType = name;
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
    }

    /**
     * Returns the width of tiles
     * @return the width of tiles
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of tiles
     * @return the height of tiles
     */
    public int getHeight() {
        return height;
    }

    /**
     * Checks if the tile the player is on contains an encounter
     * @param playerPos The position of the player
     * @return true if the tile contains an encounter, false otherwise
     */
    public boolean tryEncounter(Point playerPos){
        return getTile(playerPos).canEncounter();
    }

    /**
     * Returns the terrain type of the current map
     * @return the terrain type of the current map
     */
    public String getTerrainType(){
        return terrainType;
    }

    /**
     * Returns the starting position of the player on the x-axis
     * @return the starting position of the player on the x-axis
     */
    public int getStartPosX() {
        return startPosX;
    }

    /**
     * Returns the starting position of the player on the y-axis
     * @return the starting position of the player on the y-axis
     */
    public int getStartPosY() {
        return startPosY;
    }

    /**
     * Checks if the current tile contains a transporter
     * @param playerPos The position of the player
     * @return true if the tile contains a transporter, false otherwise
     */
    public boolean hasTransporter(Point playerPos){
        return getTile(playerPos).hasTransporter();
    }

    /**
     * Returns the transporter of the current tile
     * @param pos The position of the transporter
     * @return the transporter of the current tile
     */
    public Transporter getTransporter(Point pos){
        return getTile(pos).getTransporter();
    }

    /**
     * Checks if the tile at (x,y) contains a collision
     * @param x The x-coordinate of the tile
     * @param y The y-coordinate of the tile
     * @return true if the tile contains a collision, false otherwise
     */
    public boolean isCollision(int x, int y) {
        return getTile(x, y).isCollision();
    }

    /**
     * Changes the startPos of the map to the given position
     * @param newStartPos The new starting position of the player
     */
    protected void setStartPos(Point newStartPos) {
        startPosX = newStartPos.x;
        startPosY = newStartPos.y;
    }

    /**
     * Returns the tile at (x,y)
     * @param xPos The x-coordinate of the tile
     * @param yPos The y-coordinate of the tile
     * @return the tile at (x,y)
     */
    private Tile getTile(int xPos, int yPos){
        return tiles[xPos][yPos];
    }

    /**
     * Returns the tile at the given position
     * @param point The position of the tile
     * @return the tile at the given position
     */
    private Tile getTile(Point point){
        return getTile(point.x, point.y);
    }
}
