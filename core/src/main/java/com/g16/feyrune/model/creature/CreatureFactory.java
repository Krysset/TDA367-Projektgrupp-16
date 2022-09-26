package com.g16.feyrune.model.creature;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.action.BaseAttack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.g16.feyrune.Util.Pair;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICreature createCreature(String attackNames[], int health, int power, int speed, int evasion) {
        BaseAttack[] baseAttackList= new BaseAttack[attackNames.length];
        for(int i = 0; i < attackNames.length; i++){
            baseAttackList[i] = createAttackByName(attackNames[i]);
        }
        return new BaseCreature(100,75,50,33, baseAttackList);
    }

    public static ICreature[] createCreatureList(Pair<String, Integer>[] monsterList, int wantedAmount){
        ICreature[] iCreatures = new ICreature[wantedAmount];
        for(int i = 0; i < wantedAmount; i++){
            String nextMonster = calculateCreatureToUse(monsterList);
        }
        return iCreatures;
    }
    private static String calculateCreatureToUse(Pair<String, Integer>[] monsterList){
        int monsterCards = 0;
        for(Pair<String, Integer> monster : monsterList){
            monsterCards += monster.getSnd();
        }
        int random = Random.randomInt( monsterCards);
        for(Pair<String, Integer> monster : monsterList){
            random -= monster.getSnd();
            if(random <= 0){
                return monster.getFst();
            }
        }
        return "default";
    }
    private ICreature createCreatureByName(String name){
        switch (name){
            case "SuperAwesomeBaseMonster":
                return createCreature(new String[] {"SuperAwesomeBaseAttack"}, 100, 75, 50, 33);
            case "SuperBadBaseMonster":
                return createCreature(new String[] {"SuperBadStandardAttack"}, 50, 15, 10, 85);
            default:
                throw new NotImplementedException();
        }
    }

    private static BaseAttack createAttackByName(String name){
        switch (name){
            case "SuperAwesomeBaseAttack":
                return new BaseAttack(100,100,"SuperAwesomeBaseAttack");
            case "SuperBadStandardAttack":
                return new BaseAttack(50,50,"SuperBadStandardAttack");
            default:
                throw new NotImplementedException();
        }
    }
}
