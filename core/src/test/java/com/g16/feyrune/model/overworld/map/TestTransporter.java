package com.g16.feyrune.model.overworld.map;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TestTransporter {
    @Test
    public void testGetFromX() {
        int expectedValue = 5;
        Transporter t = new Transporter("test", new Point(expectedValue,1), new Point(2, 3));
        assertEquals(expectedValue, t.getFromX());
    }

    @Test
    public void testGetFromY() {
        int expectedValue = 5;
        Transporter t = new Transporter("test", new Point(0,expectedValue), new Point(2, 3));
        assertEquals(expectedValue, t.getFromY());
    }
    @Test
    public void testGetTransitionTo() {
        Point expected = new Point(6, 9);
        Transporter t = new Transporter("test", new Point(0, 1), new Point(expected));
        Point actual = t.getTransitionTo();
        assertEquals(expected.x, actual.x);
        assertEquals(expected.y, actual.y);
    }

    @Test
    public void getMapAssetPath() {
        String expected = "test";
        Transporter t = new Transporter(expected, new Point(), new Point());
        assertEquals(expected, t.getMapAssetPath());
    }
}
