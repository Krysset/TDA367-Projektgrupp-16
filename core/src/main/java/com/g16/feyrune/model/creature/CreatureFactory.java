package com.g16.feyrune.model.creature;

import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.action.BaseAttack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import com.g16.feyrune.Util.Pair;

public class CreatureFactory {
    /**
     *
     * @return a new Object of type ICreature
     */
    public static ICreature createCreature() {
        BaseAttack[] baseAttackList= new BaseAttack[1];
        baseAttackList[0] = new BaseAttack(100,100,"SuperAwesomeBaseAttack");
        return new BaseCreature(100,75,50,33, baseAttackList);

    }
    public static ICreature[] createCreatureList(Pair<Integer, Integer>[] monsterList, int wantedAmount){
        ICreature[] iCreatures = new ICreature[wantedAmount];
        for(int i = 0; i < wantedAmount; i++){
            iCreatures[i] = createCreature();
        }
        return iCreatures;
    }
}
