package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.overworld.map.MapManager;

public class TextureMapManager implements IMapObserver {
    private TextureMap textureMap;

    public TextureMapManager(MapManager mapManager) {
        textureMap = TextureMapParser.parseMapFile("assets/maps/plains1.tmx");
        mapManager.subscribeMapObserver(this);
    }

    public void render(SpriteBatch batch) {
        textureMap.render(batch);
    }

    public Color getBgColor() {
        return textureMap.getBgColor();
    }

    public int getTileSize() {
        return textureMap.getTileSize();
    }

    @Override
    public void updateMap(String mapAssetPath) {
        textureMap = TextureMapParser.parseMapFile(mapAssetPath);
    }
}
