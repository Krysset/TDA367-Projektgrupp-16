package com.g16.feyrune.model.player;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TestPlayer {
    @Test
    public void testMove() {
        int startX = 5, startY = 7;
        Player p = new Player("Test", new Point(startX, startY));
        p.move(1, 0);
        assertNotEquals(startX, p.getCoordinates().x);
        assertEquals(startY, p.getCoordinates().y);
        p.move(0, 1);
        assertNotEquals(startX, p.getCoordinates().x);
        assertNotEquals(startY, p.getCoordinates().y);
    }
    @Test
    public void testSetPosition() {
        int startX = 5, startY = 7;
        int newX = 1, newY = 1;
        Player p = new Player("Test", new Point(startX, startY));
        p.setPosition(newX, newY);
        assertEquals(newX, p.getCoordinates().x);
        assertEquals(newY, p.getCoordinates().y);
    }
    @Test
    public void testGetCoordinates() {
        int startX = 5, startY = 7;
        Player p = new Player("Test", new Point(startX, startY));
        assertEquals(startX, p.getCoordinates().x);
        assertEquals(startY, p.getCoordinates().y);
    }
    @Test
    public void testGetName() {
        String expected = "Test";
        Player p = new Player(expected, new Point());
        assertEquals(expected, p.getName());
    }
    @Test
    public void testSetName() {
        String expected = "Test";
        Player p = new Player("Banan", new Point());
        p.setName(expected);
        assertEquals(expected, p.getName());
    }
    @Test
    public void testGetPlayerCreature() {
        Player p = new Player("Test", new Point());
        assertNotNull(p.getPlayerCreature());
    }
    @Test
    public void testCreatureIsDead() {
        Player p = new Player("Test", new Point());
        assertFalse(p.creatureIsDead());
        p.getPlayerCreature().takeDamage(99999999);
        assertTrue(p.creatureIsDead());
    }
    @Test
    public void testHealTeam() {
        // TODO: Not implemented in model yet
    }
}
