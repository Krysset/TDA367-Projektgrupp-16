package com.g16.feyrune.model.creature;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.IAbility;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.actions.AbilityFactory;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import com.g16.feyrune.Util.Pair;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICreature createCreature(String[] abilities, double health, int power, int speed, int evasion) {
        BaseAbility[] baseAbilityList = AbilityFactory.createAttackList(abilities);
        return new BaseCreature(health,power, speed, evasion, baseAbilityList);
    }
    public static ICreature[] createCreatureList(Pair<Integer, Integer>[] monsterList, int wantedAmount){
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
                return createCreature(new String[]{"SuperAwesomeBaseAbility"}, 100, 100, 100, 100);
            case "SuperBadBaseMonster":
                return createCreature(new String[]{"SuperBadBaseAbility"}, 100, 100, 100, 100);
            default:
                return createCreature(new String[]{"SuperBasicBaseAbility"}, 100, 100, 100, 100);
        }
    }
}
