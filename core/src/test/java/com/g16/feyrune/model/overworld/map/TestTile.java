package com.g16.feyrune.model.overworld.map;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestTile {
    @Test
    public void testCanEncounter() {
        Tile tile = new Tile(false);
        assertFalse(tile.canEncounter());
    }
    @Test
    public void testHasCollision() {
        Tile tile = new Tile(true);
        assertTrue(tile.isCollision());
        tile = new Tile(false);
        assertFalse(tile.isCollision());
    }
    @Test
    public void testSetCanEncounter() {
        Tile tile = new Tile(false);
        assertFalse(tile.canEncounter());
        tile.setCanEncounter(true);
        assertTrue(tile.canEncounter());
    }
    @Test
    public void testHasTransporter() {
        Tile t = new Tile(false);
        assertFalse(t.hasTransporter());
    }
    @Test
    public void testSetTransporter() {
        Tile t = new Tile(false);
        assertFalse(t.hasTransporter());
        t.setTransporter(new Transporter("test", new Point(), new Point()));
        assertTrue(t.hasTransporter());
    }
    @Test
    public void testGetTransportCoordinates() {
        Tile t = new Tile(false);
        t.setTransporter(new Transporter("test", new Point(1,2), new Point(3,4)));
        assertEquals(3, t.getTransportCoordinates().x);
        assertEquals(4, t.getTransportCoordinates().y);
    }
    @Test
    public void testGetTransportMapAssetPath() {
        Tile t = new Tile(false);
        t.setTransporter(new Transporter("test", new Point(), new Point()));
        assertEquals("test", t.getTransportMapAssetPath());
    }
}
