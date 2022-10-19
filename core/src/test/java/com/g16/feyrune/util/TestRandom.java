package com.g16.feyrune.util;

import com.g16.feyrune.Util.Random;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRandom {
    @Test
    public void testRandomInt() {
        int testValue = 10;
        int result = Random.randomInt(testValue);
        assertTrue(result <= testValue & result >= 0);
    }
}
