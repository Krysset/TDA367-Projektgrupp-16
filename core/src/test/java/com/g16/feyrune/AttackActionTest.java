package com.g16.feyrune;

import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.model.combat.actions.AbilityFactory;
import com.g16.feyrune.model.combat.actions.AttackAction;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.creature.BaseCreature;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AttackActionTest {
    @Test
    public void testExecuteMove() {
        AttackAction attackAction = new AttackAction();
        List<IAbilitable> abilities = new ArrayList<>();
        abilities.add(AbilityFactory.createAbility("test", 90, 100));
        BaseCreature enemyBase=new BaseCreature(100,100,100,100,abilities);
        attackAction.executeMove(new EnemyCreature(enemyBase), new EnemyCreature(enemyBase));
    }
}
