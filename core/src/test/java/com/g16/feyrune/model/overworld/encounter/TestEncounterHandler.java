package com.g16.feyrune.model.overworld.encounter;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestEncounterHandler {
    @Test
    public void testCreateEncounter() {
        EncounterHandler eh = new EncounterHandler();
        Encounter e = eh.createEncounter("test");
        assertNotNull(e);
    }
}
