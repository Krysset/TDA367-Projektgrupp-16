package com.g16.feyrune.view.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Image {

    /**
     * Resizes the given texture to the given scaler using a nearest neighbour algorithm.
     * @param texture The texture to resize.
     * @param scaleXY The scale factor.
     * @return The resized texture.
     */
    public static Texture resize(Texture texture, float scaleXY) {
        return resize(texture, scaleXY, scaleXY);
    }

    /**
     * Resizes the given texture to the given scalers using a nearest neighbour algorithm.
     * @param texture The texture to resize.
     * @param scaleX The scale factor in the x axis.
     * @param scaleY The scale factor in the y axis.
     * @return The resized texture.
     */
    public static Texture resize(Texture texture, float scaleX, float scaleY) {
        // Uses the texture object to read the file again (may become a IO performance issue in the future)
        Pixmap basePixmap = new Pixmap(Gdx.files.internal(texture.toString()));

        // Creates a new pixmap with the new size
        Pixmap resizedPixmap = new Pixmap(Math.round(texture.getWidth() * scaleX), Math.round(texture.getHeight() * scaleY), basePixmap.getFormat());

        // Draws the base pixmap into the resized one using Nearest Neighbour interpolation
        // link: https://en.wikipedia.org/wiki/Nearest-neighbor_interpolation
        resizedPixmap.setFilter(Pixmap.Filter.NearestNeighbour);
        resizedPixmap.drawPixmap(basePixmap,
                0, 0, basePixmap.getWidth(), basePixmap.getHeight(),
                0, 0, resizedPixmap.getWidth(), resizedPixmap.getHeight()
        );

        // Creates a new texture from the resized pixmap
        Texture resizedTexture = new Texture(resizedPixmap);
        basePixmap.dispose();
        resizedPixmap.dispose();

        return resizedTexture;
    }
}
