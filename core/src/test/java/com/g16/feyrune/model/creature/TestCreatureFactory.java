package com.g16.feyrune.model.creature;

import com.g16.feyrune.Util.Pair;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestCreatureFactory {
    @Test
    public void testCreateCreature() {
        assertNotNull(CreatureFactory.createCreature());
        assertNotNull(CreatureFactory.createCreature(new String[]{}, 5,  5, 5, 5));
    }
    @Test
    public void testCreateCreatureList() {
        Pair<String, Integer>[] a;
        a = new Pair[1];
        a[0] = new Pair<>("test", 5);
        assertNotNull(CreatureFactory.createCreatureList(a, 1));
    }
}
