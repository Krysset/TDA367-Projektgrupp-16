package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.creature.CreatureFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EncounterHandler {
    private static Pair<String, Integer>[] dungeonTerrainMonstersList;
    private static Pair<String, Integer>[] testTerrainMonstersList;

    {
        dungeonTerrainMonstersList = new Pair[]{
                new Pair<>("SuperAwesomeBaseMonster", 10),
                new Pair<>("SuperBadBaseMonster", 90)
        };
        testTerrainMonstersList = new Pair[]{
                new Pair<>("SuperAwesomeBaseMonster", 10)
        };
    }
    public EncounterHandler() {
        // TODO: Use dependency injection
    }

    /**
     *
     * @return
     */
    public Encounter createEncounter(String terrainType) {
        ICombatable[] iCreatureList = getMonsterList(terrainType, 1);
        Encounter newEncounter = new Encounter(iCreatureList);
        return newEncounter;
    } //TODO: Implemented statically

    private ICombatable[] getMonsterList(String TerrainType, int wantedAmount){
        switch (TerrainType){
            case "dungeon":
            case "plains":
                return CreatureFactory.createCreatureList(dungeonTerrainMonstersList, wantedAmount);
            case "test":
                return CreatureFactory.createCreatureList(testTerrainMonstersList, wantedAmount);
            default:
                throw new NotImplementedException();
        }
    }



}
