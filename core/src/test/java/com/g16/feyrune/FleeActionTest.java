package com.g16.feyrune;

import com.g16.feyrune.model.combat.actions.FleeAction;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.creature.BaseCreature;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FleeActionTest {
    @Test
    public void FleeActionfailedMove() {
        FleeAction fleeAction = new FleeAction();
        BaseCreature enemyBase=new BaseCreature(100,100,100,100, null);
        fleeAction.executeMove(new EnemyCreature(enemyBase), new EnemyCreature(enemyBase));
        assertFalse(fleeAction.executeMove(new EnemyCreature(enemyBase), new EnemyCreature(enemyBase)));
    }
    @Test
    public void FleeActionSuccessfulMove() {
        FleeAction fleeAction = new FleeAction();
        BaseCreature enemyBase=new BaseCreature(100,100,100,100, null);
        BaseCreature enemyBase2=new BaseCreature(100,100,99,100, null); //lower speed then actor
        fleeAction.executeMove(new EnemyCreature(enemyBase), new EnemyCreature(enemyBase));
        assertTrue(fleeAction.executeMove(new EnemyCreature(enemyBase), new EnemyCreature(enemyBase2)));
    }
}
