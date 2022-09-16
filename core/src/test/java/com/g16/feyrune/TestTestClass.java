package com.g16.feyrune;

import com.g16.feyrune.Util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTestClass {

    @Test
    public void TestTest() {
        Pair<Integer, Integer> testPair = new Pair<>(1, 2);

        assertEquals(1, (int)testPair.getFst());
        assertEquals(2, (int)testPair.getSnd());
    }
}
