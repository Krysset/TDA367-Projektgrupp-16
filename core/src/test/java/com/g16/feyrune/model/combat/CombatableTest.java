package com.g16.feyrune.model.combat;

import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.model.combat.actions.AbilityFactory;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.overworld.encounter.EncounterHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombatableTest {
    @Test
    public void testCalculateAttack() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        IAbilitable attack = AbilityFactory.createAbility("test", 90, 100);
        assertEquals(testEncounter.getEnemyCreature()[0].calculateAttack(attack), 90);

    }

    @Test
    public void testTakeDamage() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        IAbilitable attack = AbilityFactory.createAbility("test", 90, 100);
        testEncounter.getEnemyCreature()[0].takeDamage(attack.getAttackPower());
        assertEquals((testEncounter.getEnemyCreature()[0]).getHP(), 225, 0.1);

    }

    @Test
    public void testIsDead() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        testEncounter.getEnemyCreature()[0].takeDamage(1000);
        assertEquals(testEncounter.getEnemyCreature()[0].isDead(), true);
    }
    @Test
    public void TestIsNotDead() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        testEncounter.getEnemyCreature()[0].takeDamage(100);
        assertEquals(testEncounter.getEnemyCreature()[0].isDead(), false);
    }
    @Test
    public void TestStrangeValues() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        testEncounter.getEnemyCreature()[0].takeDamage(-100);
        assertEquals(testEncounter.getEnemyCreature()[0].isDead(), false);
    }

    @Test
    public void testGetSpeed() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        assertEquals(testEncounter.getEnemyCreature()[0].getSpeed(), 10);
    }

    @Test
    public void testGetHP() {
        EncounterHandler encounterHandler = new EncounterHandler();
        Encounter testEncounter = encounterHandler.createEncounter("test");
        assertEquals(testEncounter.getEnemyCreature()[0].getHP(), 250.0, 0);
    }
}