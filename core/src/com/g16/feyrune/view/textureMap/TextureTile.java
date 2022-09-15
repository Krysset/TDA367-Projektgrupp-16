package com.g16.feyrune.view.textureMap;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;
import java.util.HashMap;

public class TextureTile {
    private int[] gIds;
    private HashMap<Integer, TextureRegion> gIdToTextureMap;

    public TextureTile(int[] gIds, HashMap<Integer, TextureRegion> gIdToTextureMap) {
        this.gIds = gIds;
        this.gIdToTextureMap = gIdToTextureMap;
    }

    protected void draw(Batch batch, Point coordinates) {
        for (int gId : gIds) {
            if (gId != 0) {
                batch.draw(gIdToTextureMap.get(gId), coordinates.x, coordinates.y);
            }
        }
    }
}
