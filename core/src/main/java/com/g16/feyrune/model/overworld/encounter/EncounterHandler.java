package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.model.creature.ICreature;
import com.g16.feyrune.model.creature.CreatureFactory;
import com.g16.feyrune.Util.Pair;

public class EncounterHandler {
    public EncounterHandler() {
    }

    /**
     *
     * @return
     */
    public Encounter createEncounter(Pair<Integer, Integer>[] monsterList) {
       ICreature[] iCreatureList = CreatureFactory.createCreatureList(monsterList);
        Encounter newEncounter = new Encounter(iCreatureList);
        return newEncounter;
    } //TODO: Implemented statically
}
