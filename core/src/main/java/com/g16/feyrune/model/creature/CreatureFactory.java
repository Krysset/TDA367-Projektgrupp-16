package com.g16.feyrune.model.creature;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import com.g16.feyrune.Util.Pair;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICreature createCreature() {
        BaseAbility[] baseAbilityList = new BaseAbility[1];
        baseAbilityList[0] = new BaseAbility(100,100,"SuperAwesomeBaseAttack");
        return new BaseCreature(100,75,50,33, baseAbilityList);

    }
    public static ICreature[] createCreatureList(Pair<Integer, Integer>[] monsterList){
        ICreature[] iCreatures = new ICreature[1];
        iCreatures[0] = createCreature();
        return iCreatures;
    }
}
