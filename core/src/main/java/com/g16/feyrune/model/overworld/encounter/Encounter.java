package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.interfaces.ICreature;

public class Encounter {
    private final ICreature[] enemyCreature;

    public Encounter(ICreature[] enemyCreature) {
        this.enemyCreature = enemyCreature;
    }

    public ICreature[] getEnemyCreature() {
        return enemyCreature;
    }

}
