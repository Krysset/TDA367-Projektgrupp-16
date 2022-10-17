package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.overworld.map.MapManager;

public class TextureMapManager implements IMapObserver {
    private TextureMap textureMap;

    /**
     * Constructor for the TextureMapManager
     * @param mapManager the map manager to get the map from
     */
    public TextureMapManager(MapManager mapManager) {
        textureMap = TextureMapParser.parseMapFile("assets/maps/plains1.tmx");
        mapManager.subscribeMapObserver(this);
    }

    /**
     * Draws the map
     * @param batch the sprite batch to draw with
     */
    public void render(SpriteBatch batch) {
        textureMap.render(batch);
    }

    /**
     * Returns the background colour of the map
     * @return the background colour of the map
     */
    public Color getBgColor() {
        return textureMap.getBgColor();
    }

    /**
     * Returns the width of each tile in the map
     * @return the width of each tile in the map
     */
    public int getTileSize() {
        return textureMap.getTileSize();
    }

    /**
     * Replaces the texture map with a new one
     * @param mapAssetPath the path to the new map
     */
    @Override
    public void updateMap(String mapAssetPath) {
        textureMap = TextureMapParser.parseMapFile(mapAssetPath);
    }
}
