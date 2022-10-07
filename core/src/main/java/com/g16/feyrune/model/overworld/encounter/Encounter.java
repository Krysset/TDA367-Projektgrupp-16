package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.interfaces.ICombatable;

public class Encounter {
    private final ICombatable[] enemyCreature;

    public Encounter(ICombatable[] enemyCreature) {
        this.enemyCreature = enemyCreature;
    }

    public ICombatable[] getEnemyCreature() {
        return enemyCreature;
    }

}
