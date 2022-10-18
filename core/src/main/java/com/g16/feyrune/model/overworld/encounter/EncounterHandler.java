package com.g16.feyrune.model.overworld.encounter;

import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.creature.CreatureFactory;


public class EncounterHandler {
    private static String[][] dungeonTerrainMonstersList;
    private static String[][] testTerrainMonstersList;
    private static String[][] plainsTerrainMonstersList;

    {
        dungeonTerrainMonstersList = new String[][]{
                {"ghost", "goblinking", "ogre"},
                {"10","1","89"}
        };
        testTerrainMonstersList = new String[][]{
                {"SuperAwesomeBaseMonster"},{"10"}
        };
        plainsTerrainMonstersList = new String[][]{
                {"boar","thief"},
                {"10","90"}
        };
    }
    public EncounterHandler() {
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

    private int[] convertToInts(String[] strings){
        int[] ints = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    private ICombatable[] getMonsterList(String TerrainType, int wantedAmount){
        try{
            switch (TerrainType){
                case "dungeon":
                    return CreatureFactory.createCreatureList(dungeonTerrainMonstersList[0], convertToInts(dungeonTerrainMonstersList[1]), wantedAmount);
                case "test":
                    return CreatureFactory.createCreatureList(testTerrainMonstersList[0],convertToInts(testTerrainMonstersList[1]), wantedAmount);
                case "plains":
                    return CreatureFactory.createCreatureList(plainsTerrainMonstersList[0],convertToInts(plainsTerrainMonstersList[1]), wantedAmount);
                default:
                    throw new Exception("TerrainType not found");
            }
        } catch (Exception e){
            return new ICombatable[]{CreatureFactory.createCreature()};
        }

    }



}
