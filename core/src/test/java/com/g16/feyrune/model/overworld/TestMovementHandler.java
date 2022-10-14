package com.g16.feyrune.model.overworld;

import com.g16.feyrune.model.overworld.map.MapManager;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestMovementHandler {
    @Test
    public void testIncreaseXDirection() {
        Point expected = new Point();
        MovementHandler mh = new MovementHandler();
        mh.increaseXDirection();
        Point actual = mh.calculateMovement(new Point(1,1), new MapManager("assets/maps/plains1.tmx"));
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }
    @Test
    public void testDecreaseXDirection() {
        MovementHandler mh = new MovementHandler();
    }
    @Test
    public void testIncreaseYDirection() {

    }
    @Test
    public void testDecreaseYDirection() {

    }
    @Test
    public void testResetDirectionX() {

    }
    @Test
    public void testResetDirectionY() {

    }
    @Test
    public void testResetMovement() {

    }
    @Test
    public void testCalculateMovement() {

    }
}
