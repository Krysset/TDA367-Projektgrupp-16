package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.interfaces.ICombatable;

public class Encounter {
    /**
     * The creatures in the encounter not controlled by the player
     */
    private final ICombatable[] enemyCreature;

    /**
     * Constructor for the encounter
     * @param enemyCreature List of creatures to be fought by the player in this combat
     */
    public Encounter(ICombatable[] enemyCreature) {
        this.enemyCreature = enemyCreature;
    }

    /**
     * Returns the enemy creatures in the encounter
     * @return the enemy creatures in the encounter
     */
    public ICombatable[] getEnemyCreature() {
        return enemyCreature;
    }

}
