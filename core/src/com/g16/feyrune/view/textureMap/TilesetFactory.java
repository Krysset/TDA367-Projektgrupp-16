package com.g16.feyrune.view.textureMap;

import com.g16.feyrune.map.Tile;

import java.io.File;
import java.io.FileNotFoundException;

public class TilesetFactory {
    private int firstGid, tileWidth, tileHeight, tileCount, columns;
    private String name;
    private String imgSource;

    public void setFirstGid(String firstGid) {
        try {
            this.firstGid = Integer.parseInt(firstGid);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse firstgid, received: " + firstGid + "but expected number");
            System.out.println(e.getMessage());
        }
    }

    public void setTileWidth(String tileWidth) {
        try {
            this.tileWidth = Integer.parseInt(tileWidth);
        } catch (NumberFormatException e) {
        System.out.println("Failed to parse tileWidth, received: " + tileWidth + "but expected number");
        System.out.println(e.getMessage());
        }
    }

    public void setTileHeight(String tileHeight) {
        try {
            this.tileHeight = Integer.parseInt(tileHeight);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse tileHeight, received: " + tileHeight + "but expected number");
            System.out.println(e.getMessage());
        }
    }

    public void setTileCount(String tileCount) {
        try {
            this.tileCount = Integer.parseInt(tileCount);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse tileHeight, received: " + tileCount + "but expected number");
            System.out.println(e.getMessage());
        }
    }

    public void setColumns(String columns) {
        try {
            this.columns = Integer.parseInt(columns);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse tileHeight, received: " + columns + "but expected number");
            System.out.println(e.getMessage());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgSource(String imgSource) throws FileNotFoundException {
        if ((new File(imgSource)).exists()) {
            this.imgSource = imgSource;
        } else {
            System.out.println("Image for tileset not found! Got source: " + imgSource);
            throw new FileNotFoundException();
        }
    }

    public Tileset createTileset() {
        if (name.equals("")) {
            System.out.println("Tileset name is not set");
        }
        if (imgSource.equals("")) {
            System.out.println("Tileset img source is not set");
        }
        if (firstGid == 0) {
            System.out.println("Tileset firstGid is not set");
        }
        if (tileWidth == 0) {
            System.out.println("Tileset tileWidth is not set");
        }
        if (tileHeight == 0) {
            System.out.println("Tileset tileHeight is not set");
        }
        if (tileCount == 0) {
            System.out.println("Tileset tileCount is not set");
        }
        if (columns == 0) {
            System.out.println("Tileset columns is not set");
        }
        Tileset tileset = new Tileset(imgSource, name, firstGid, tileWidth, tileHeight, tileCount, columns);
        reset();
        return tileset;
    }
    private void reset() {
        firstGid = 0;
        tileWidth = 0;
        tileHeight = 0;
        tileCount = 0;
        columns = 0;
        name = "";
        imgSource = "";
    }
}
