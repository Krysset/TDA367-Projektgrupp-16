package com.g16.feyrune.view.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationUtils {
    public static TextureRegion[] getAnimationFrames(Texture texture, int sizeX, int sizeY, int numOfFrames, int animationPosition){

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth() / sizeX,
                texture.getHeight() / sizeY);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] frames = new TextureRegion[sizeX * sizeY];
        int index = 0;

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                frames[index++] = tmp[i][j];
            }
        }

        TextureRegion[] animationFrames = new TextureRegion[numOfFrames];
        for(int i = 0; i < numOfFrames; i++){
            animationFrames[i] = frames[animationPosition + i];
        }

        return animationFrames;
    }
}
