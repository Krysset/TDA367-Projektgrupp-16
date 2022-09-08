package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void draw(SpriteBatch batch, List<Tileset> tilesets) {
        for (Map.Entry<Point, Integer> entry : textureTileMap.entrySet()) {
            Point coordinate = entry.getKey();
            int gid = entry.getValue();
            int tilesetIndex = 0;
            while(gid < tilesets.get(tilesetIndex).getFirstgid()) {
                tilesetIndex++;
            }
            batch.draw(tilesets.get(tilesetIndex).getTexture(gid),coordinate.x, coordinate.y);
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
