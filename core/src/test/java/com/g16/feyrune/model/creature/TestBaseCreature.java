package com.g16.feyrune.model.creature;

import com.badlogic.gdx.utils.compression.lzma.Base;
import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestBaseCreature {
    @Test
    public void testGetMoves() {
        String expectedName = "test";
        List<IAbilitable> moves = new ArrayList<IAbilitable>();
        moves.add(new BaseAbility(100, 5, expectedName));
        BaseCreature c = new BaseCreature(10, 5, 5, 5, moves);
        assertEquals(expectedName, c.getMoves().get(0).getAttackName());
    }
    @Test
    public void testCalculateAttack() {
        IAbilitable testAbility = new BaseAbility(100, 50, "test");
        BaseCreature c = new BaseCreature(10, 5, 5, 5, new ArrayList<IAbilitable>());
        assertTrue(0 < c.calculateAttack(testAbility));
    }
    @Test
    public void testGetHP() {
        int expected = 10;
        BaseCreature c = new BaseCreature(expected, 5, 5, 5, new ArrayList<IAbilitable>());
        assertEquals(expected, c.getHP(), 0.0001);
    }
    @Test
    public void testGetPower() {
        int expected = 7;
        BaseCreature c = new BaseCreature(10, expected, 5, 5, new ArrayList<IAbilitable>());
        assertEquals(expected, c.getPower());
    }
    @Test
    public void testTakeDamage() {
        double startHealth = 10;
        BaseCreature c = new BaseCreature(startHealth, 5, 5, 5, new ArrayList<IAbilitable>());
        assertEquals(startHealth, c.getHP(), 0.0001);
        c.takeDamage(5);
        assertTrue(c.getHP() < startHealth);
    }
    @Test
    public void testIsDead() {
        BaseCreature c = new BaseCreature(10, 5, 5, 5, new ArrayList<IAbilitable>());
        assertFalse(c.isDead());
        c.takeDamage(999999999);
        assertTrue(c.isDead());
    }
    @Test
    public void testGetSpeed() {
        int expected = 7;
        BaseCreature c = new BaseCreature(10, 5, expected, 5, new ArrayList<IAbilitable>());
        assertEquals(expected, c.getSpeed());
    }
}
