package com.g16.feyrune.view.overworld.textureMap;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.*;
import java.util.HashMap;

public class TextureTile {
    // Is an array of gIds because the first index of the array represents the first layer,
    // the second index represents the second layer, and so on.
    private int[] gIds;

    public TextureTile(int[] gIds) {
        this.gIds = gIds;
    }

    protected void draw(Batch batch, Point coordinates, HashMap<Integer, TextureRegion> gIdToTextureMap) {
        for (int gId : gIds) {
            if (gId != 0) {
                batch.draw(gIdToTextureMap.get(gId), coordinates.x, coordinates.y);
            }
        }
    }
}
