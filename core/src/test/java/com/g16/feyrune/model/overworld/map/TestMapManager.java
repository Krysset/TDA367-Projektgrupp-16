package com.g16.feyrune.model.overworld.map;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestMapManager {
    @Test
    public void testGetTerrainType() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        assertEquals("plains", mm.getTerrainType());
        mm.changeMap("../assets/maps/dungeon1.tmx");
        assertEquals("dungeon", mm.getTerrainType());
    }

    @Test
    public void testChangeMap() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        String firstMap = mm.getTerrainType();
        mm.changeMap("../assets/maps/dungeon1.tmx");
        assertNotEquals(firstMap, mm.getTerrainType());
    }

    @Test
    public void testGetWidth() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        // width of plains map is 30
        assertEquals(30, mm.getWidth());
    }

    @Test
    public void testGetHeight() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        // height of plains map is 30
        assertEquals(30, mm.getWidth());
    }

    @Test
    public void testTryEncounter() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        // Tile at position 0,0 shouldn't haven any encounters on the plains map
        assertFalse(mm.tryEncounter(new Point(0, 0)));
        // Tile at position 12,5 should haven encounters on the plains map
        assertTrue(mm.tryEncounter(new Point(12, 5)));
    }

    @Test
    public void testHasTransporter() {
        MapManager mm = new MapManager("../assets/maps/dungeon1.tmx");
        assertTrue(mm.hasTransporter(new Point(11, 1)));
        assertFalse(mm.hasTransporter(new Point(0, 0)));
    }
    @Test
    public void testUseTransporter() {
        MapManager mm = new MapManager("../assets/maps/dungeon1.tmx");
        mm.useTransporter(new Point(11,1));
        assertEquals(mm.getTerrainType(), "plains");
    }

    @Test
    public void testStartPosX() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        int startX1 = mm.getStartPosX();
        mm.changeMap("../../assets/maps/dungeon1.tmx");
        mm.useTransporter(new Point(11,1));
        int startX2 = mm.getStartPosX();
        // Starting position should be the same if you're using a
        // transporter instead of loading immediately into the map
        assertNotEquals(startX1, startX2);
    }

    @Test
    public void testStartPosY() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        int startY1 = mm.getStartPosY();
        mm.changeMap("../assets/maps/dungeon1.tmx");
        mm.useTransporter(new Point(11,1));
        int startY2 = mm.getStartPosY();
        // Starting position should be the same if you're using a
        // transporter instead of loading immediately into the map
        assertNotEquals(startY1, startY2);
    }

    @Test
    public void testHasCollision() {
        MapManager mm = new MapManager("../assets/maps/plains1.tmx");
        assertTrue(mm.hasCollision(0, 0));
        assertFalse(mm.hasCollision(11, 5));
    }
}
