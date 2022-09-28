package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;

public class AbilityFactory {
    public static BaseAbility createAbility(String name, int accuracy, int power) {
        return new BaseAbility(accuracy, power, name);
    }

    public static BaseAbility[] createAbilityList(String[] names) {
        BaseAbility[] attacks = new BaseAbility[names.length];
        for (int i = 0; i < names.length; i++) {
            
            attacks[i] = createAbilityByName(names[i]);
        }
        return attacks;
    }

    private static BaseAbility createAbilityByName(String name) {
        switch (name) {
            case "SuperAwesomeBaseAbility":
                return new BaseAbility(100, 100, name);
            case "SuperBadStandardAttack":
                return new BaseAbility(50, 50, name);
            default:
                return new BaseAbility(50, 50, name);
        }
    }
}
