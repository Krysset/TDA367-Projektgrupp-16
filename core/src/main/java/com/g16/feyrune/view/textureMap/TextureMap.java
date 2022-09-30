package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.overworld.map.Map;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class TextureMap {
    private final int mapWidth, mapHeight, tileWidth, tileHeight;
    private final Color bgColor;
    private final TextureTile[][] textureTiles;
    private final HashMap<Integer, TextureRegion> gIdToTextureMap;

    public TextureMap(int mapWidth, int mapHeight, int tileWidth, int tileHeight, Color backgroundColor,
                      List<Tileset> tilesets, int[][][] tileGIdMap) {
        this.bgColor = backgroundColor;
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.gIdToTextureMap = generateGIdToTextureMap(tilesets);
        this.textureTiles = generateTextureTilesFromGIdMap(tileGIdMap);

    }

    protected void render(SpriteBatch batch) {
        for(int i = 0; i < textureTiles[0].length; i++) {
            for(int j = 0; j < textureTiles.length; j++) {
                textureTiles[j][i].draw(batch, new Point(i * tileWidth, j * tileHeight), gIdToTextureMap);
            }
        }
    }

    protected Color getBgColor() {
        return new Color(bgColor);
    }

    protected int getTileSize() {
        return tileWidth;
    }
    private TextureTile[][] generateTextureTilesFromGIdMap(int[][][] tileGIdMap) {
            TextureTile[][] texTiles = new TextureTile[mapHeight][mapWidth];
            for (int i = 0; i < mapHeight; i++) {
                for (int j = 0; j < mapWidth; j++) {
                    texTiles[i][j] = new TextureTile(tileGIdMap[i][j]);
                }
            }
            return texTiles;
    }

    private HashMap<Integer, TextureRegion> generateGIdToTextureMap(List<Tileset> tilesets) {
        HashMap<Integer, TextureRegion> gIdToTextureMap = new HashMap<>();
        for (Tileset tileset : tilesets) {
            for (int i = tileset.getFirstgid(); i < tileset.getFirstgid() + tileset.getTileCount(); i++) {
                gIdToTextureMap.put(i, tileset.getTextureRegion(i));
            }
        }
        return gIdToTextureMap;
    }
}
