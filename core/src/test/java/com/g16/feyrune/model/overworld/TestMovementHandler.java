package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.overworld.map.MapParser;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestMovementHandler {
    @Test
    public void testIncreaseXDirection() {
        Point expected = new Point(1,0);
        MovementHandler mh = new MovementHandler();
        mh.increaseXDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testDecreaseXDirection() {
        Point expected = new Point(-1,0);
        MovementHandler mh = new MovementHandler();
        mh.decreaseXDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testIncreaseYDirection() {
        Point expected = new Point(0,1);
        MovementHandler mh = new MovementHandler();
        mh.increaseYDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testDecreaseYDirection() {
        Point expected = new Point(0,-1);
        MovementHandler mh = new MovementHandler();
        mh.decreaseYDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testResetDirectionX() {
        Point expected = new Point(0,0);
        MovementHandler mh = new MovementHandler();
        mh.increaseXDirection();
        mh.resetXDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testResetDirectionY() {
        Point expected = new Point(0,0);
        MovementHandler mh = new MovementHandler();
        mh.increaseYDirection();
        mh.resetYDirection();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testResetMovement() {
        Point expected = new Point(0,0);
        MovementHandler mh = new MovementHandler();
        mh.increaseYDirection();
        mh.increaseXDirection();
        mh.resetMovement();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testCalculateMovement() {
        Point expected = new Point(0,0);
        MovementHandler mh = new MovementHandler();
        mh.resetMovement();
        Point actual = mh.calculateMovement(new Point(20,20), MapParser.parseMapFile("../assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
}
