package com.g16.feyrune.model.creature;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.actions.AbilityFactory;
import com.g16.feyrune.Util.Pair;

import java.util.List;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICreature createCreature(String[] abilities, double health, int power, int speed, int defense) {
        List<IAbilitable> baseAbilityList = AbilityFactory.createAbilityList(abilities);
        return new BaseCreature(health,power, speed, defense, baseAbilityList);
    }
    public static ICreature createCreature(){
        return createCreature(new String[]{"Attack"}, 100, 10, 10, 10);
    }
    public static ICreature[] createCreatureList(Pair<String, Integer>[] monsterList, int wantedAmount){
        ICreature[] iCreatures = new ICreature[wantedAmount];
        for(int i = 0; i < wantedAmount; i++){
            String name = creatureToUse(monsterList);
            iCreatures[i] = createCreatureByName(name);
        }
        return iCreatures;
    }

    private static String creatureToUse(Pair<String, Integer>[] monsterList){
        int total = 0;
        for(int i = 0; i < monsterList.length; i++){
            total += monsterList[i].getSnd();
        }
        int random = Random.randomInt(total);
        int current = 0;
        for(int i = 0; i < monsterList.length; i++){
            current += monsterList[i].getSnd();
            if(random <= current){
                return monsterList[i].getFst();
            }
        }
        return monsterList[0].getFst();
    }
    private static ICreature createCreatureByName(String name){
        switch (name){
            case "SuperAwesomeBaseMonster":
                return createCreature(new String[]{"SuperAwesomeBaseAbility"}, 250, 90, 10, 4);
            case "SuperBadBaseMonster":
                return createCreature(new String[]{"SuperBadBaseAbility"}, 50, 25, 25, 1);
            case "ogre":
                return createCreature(new String[]{"TankyTankAbility"}, 500, 10, 10, 4);
            case "dragon":
                return createCreature(new String[]{"StrongBoyAbility"}, 100, 90, 10, 4);
            default:
                return createCreature(new String[]{"SuperBasicBaseAbility"}, 100, 50, 1, 1);
        }
    }
}
