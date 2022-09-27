package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;

public class AbilityFactory {
    public static BaseAbility createAttack(String name, int accuracy, int power) {
        return new BaseAbility(accuracy, power, name);
    }

    public static BaseAbility[] createAttackList(String[] names) {
        BaseAbility[] attacks = new BaseAbility[names.length];
        for (int i = 0; i < names.length; i++) {
            attacks[i] = createAttackByName(names[i]);
        }
        return attacks;
    }

    private static BaseAbility createAttackByName(String name) {
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
