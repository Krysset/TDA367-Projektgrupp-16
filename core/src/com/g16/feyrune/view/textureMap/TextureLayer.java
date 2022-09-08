package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.HashMap;

public class TextureLayer {
    private HashMap<Point, Integer> textureTileMap;
    private String name;
    private int mapWidth, mapHeight;
    private float layer;

    public TextureLayer(String name, int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.name = name;
        textureTileMap = new HashMap<>();
    }

    public void draw(SpriteBatch batch) {
        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                // TODO: draw tiles with batch
            }
        }
    }

    public void addTile(Point coordinate, int gid) {
        textureTileMap.put(new Point(coordinate.x, coordinate.y), gid);
    }

    public String getName() {
        return name;
    }

    public void setTile(int pos, TextureTile tile) {
        int x = pos % mapWidth;
        int y = pos / mapWidth;
        // TODO: set x,y to tile
    }
}
