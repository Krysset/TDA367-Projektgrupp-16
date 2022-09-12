package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

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
            Tileset tileset = tilesets.get(tilesetIndex);
            TextureRegion region = tileset.getTextureRegion(gid);
            batch.draw(region, coordinate.x * tileset.getTileWidth(), coordinate.y * tileset.getTileHeight());
        }
    }

    public void addTile(Point coordinate, int gid) {
        textureTileMap.put(new Point(coordinate.x, coordinate.y), gid);
    }

    public String getName() {
        return name;
    }
}
