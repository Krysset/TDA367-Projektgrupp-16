package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.model.combat.actions.AbilityFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbilityFactoryTest {
    @Test
    public void testCreateAbility() {
        AbilityFactory.createAbility("test", 90, 100);
        assertEquals(AbilityFactory.createAbility("test", 90, 100).getAttackPower(), 100);
    }
    @Test
    public void testCreateAbilityList() {
        AbilityFactory.createAbilityList(new String[]{"test", "test2"});
        assertEquals(AbilityFactory.createAbilityList(new String[]{"test", "test2"}).size(), 2);
    }

}
