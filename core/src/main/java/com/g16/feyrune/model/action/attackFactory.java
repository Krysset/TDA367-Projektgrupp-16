package com.g16.feyrune.model.action;

public class attackFactory {
    public static BaseAttack createAttack(String name, int accuracy, int power) {
        return new BaseAttack(accuracy, power, name);
    }

    public static BaseAttack[] createAttackList(String[] names) {
        BaseAttack[] attacks = new BaseAttack[names.length];
        for (int i = 0; i < names.length; i++) {
            attacks[i] = createAttackByName(names[i]);
        }
        return attacks;
    }

    private static BaseAttack createAttackByName(String name) {
        switch (name) {
            case "SuperAwesomeBaseAttack":
                return new BaseAttack(100, 100, name);
            case "SuperBadStandardAttack":
                return new BaseAttack(50, 50, name);
            default:
                return new BaseAttack(50, 50, name);
        }
    }
}
