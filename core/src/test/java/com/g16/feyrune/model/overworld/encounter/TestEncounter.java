package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.creature.BaseCreature;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestEncounter {
    @Test
    public void testGetEnemyCreature() {
        ICombatable[] expected = new ICombatable[1];
        expected[0] = new BaseCreature(10, 5, 5, 5, new ArrayList<IAbilitable>());
        Encounter e = new Encounter(expected);
        assertEquals(expected[0], e.getEnemyCreature()[0]);
    }
}
