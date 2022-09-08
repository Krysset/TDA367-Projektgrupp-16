package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.model.Parser.map.Map;
import com.g16.feyrune.model.Parser.map.Tile;

import java.awt.*;
import java.util.List;


public class MapDrawer {

    public static void drawMap(SpriteBatch batch, Map map, List<Tileset> tilesets) {
        // Iterates through x and y coord
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Tile tile = map.getTile(x, y);
                for (int gid : tile.getgIds()) {
                    if (gid != 0) {
                        int index = getTileset(gid, tilesets);
                        Tileset tileset = tilesets.get(index);
                        TextureRegion region = tileset.getTextureRegion(gid);
                        batch.draw(region, x * tileset.getTileWidth(), y * tileset.getTileHeight());
                    }
                }
            }
        }
    }
    private static int getTileset(int gid, List<Tileset> tilesets) {
        int tilesetIndex = 0;
        while(gid < tilesets.get(tilesetIndex).getFirstgid()) {
            tilesetIndex++;
        }
        return tilesetIndex;
    }
}

