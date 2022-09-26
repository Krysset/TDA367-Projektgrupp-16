package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.model.creature.ICreature;

public class Encounter {
    // TODO: There should be a better implementation than just a list..
    private final ICreature[] enemyCreature;

    public Encounter(ICreature[] enemyCreature) {
        this.enemyCreature = enemyCreature;
    }

    public ICreature[] getEnemyCreature() {
        return enemyCreature;
    }

}
