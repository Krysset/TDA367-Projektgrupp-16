package com.g16.feyrune.model.creature;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.actions.AbilityFactory;

import java.util.List;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICombatable createCreature(String name, String[] abilities, double health, int power, int speed, int defense) {
        List<IAbilitable> baseAbilityList = AbilityFactory.createAbilityList(abilities);
        return new BaseCreature(name, health,power, speed, defense, baseAbilityList);
    }
    public static ICombatable createCreature(){
        return createCreature("gnome", new String[]{"Attack"}, 100, 10, 10, 10);
    }
    public static ICombatable[] createCreatureList(String[] monsters,int[] monsterCommonness, int wantedAmount){
        ICombatable[] iCreatures = new ICombatable[wantedAmount];
        for(int i = 0; i < wantedAmount; i++){
            String name = creatureToUse(monsters,monsterCommonness);
            iCreatures[i] = createCreatureByName(name);
        }
        return iCreatures;
    }

    private static String creatureToUse(String[] monsters, int[] monsterCommonness) {
        int total = 0;
        for(int i = 0; i < monsters.length; i++){
            total += monsterCommonness[i];
        }
        int random = Random.randomInt(total);
        int current = 0;
        for(int i = 0; i < monsters.length; i++){
            current += monsterCommonness[i];
            if(random <= current){
                return monsters[i];
            }
        }
        return monsters[0];
    }
    private static ICombatable createCreatureByName(String name){
        switch (name){
            case "SuperAwesomeBaseMonster":
                return createCreature(name, new String[]{"SuperAwesomeBaseAbility"}, 250, 90, 10, 4);
            case "SuperBadBaseMonster":
                return createCreature(name, new String[]{"SuperBadBaseAbility"}, 50, 25, 25, 1);
            case "ogre":
                return createCreature(name, new String[]{"TankyTankAbility"}, 500, 10, 10, 4);
            case "dragon":
                return createCreature(name, new String[]{"StrongBoyAbility"}, 100, 90, 10, 4);
            default:
                return createCreature(name, new String[]{"SuperBasicBaseAbility"}, 100, 50, 1, 1);
        }
    }
}
