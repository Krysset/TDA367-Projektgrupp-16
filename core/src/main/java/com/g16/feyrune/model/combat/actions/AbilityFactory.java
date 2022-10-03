package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.IAbility;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;

import java.util.ArrayList;
import java.util.List;

public class AbilityFactory {
    public static BaseAbility createAbility(String name, int accuracy, int power) {
        return new BaseAbility(accuracy, power, name);
    }

    public static List<IAbility> createAbilityList(String[] names) {
        List<IAbility> attacks = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            
            attacks.add(createAbilityByName(names[i]));
        }
        return attacks;
    }

    private static BaseAbility createAbilityByName(String name) {
        switch (name) {
            case "SuperAwesomeBaseAbility":
                return new BaseAbility(100, 100, name);
            case "SuperBadStandardAttack":
                return new BaseAbility(50, 50, name);
            case "StrongBoyAbility":
                return new BaseAbility(10,150, name);
                case "TankyTankAbility":
                return new BaseAbility(50,60, name);
            default:
                return new BaseAbility(50, 50, name);
        }
    }
}
