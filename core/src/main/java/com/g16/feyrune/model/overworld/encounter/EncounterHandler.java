package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.creature.CreatureFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EncounterHandler {
    private static Pair<String, Integer>[] dungeonTerrainMonstersList;

    {
        dungeonTerrainMonstersList = new Pair[]{
                new Pair<>("SuperAwesomeBaseMonster", 10),
                new Pair<>("SuperBadBaseMonster", 90)
        };
    }
    public EncounterHandler() {
    }

    /**
     *
     * @return
     */
    public Encounter createEncounter(String terrainType) {
        Pair<String, Integer>[] monsterList = getMonsterList(terrainType);

       ICreature[] iCreatureList = CreatureFactory.createCreatureList(monsterList,1);
        Encounter newEncounter = new Encounter(iCreatureList);
        return newEncounter;
    } //TODO: Implemented statically

    private Pair<String, Integer>[] getMonsterList(String TerrainType){
        switch (TerrainType){
            case "dungeon":
                return dungeonTerrainMonstersList;
            default:
                throw new NotImplementedException();
        }
    }



}
