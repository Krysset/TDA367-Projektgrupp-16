package com.g16.feyrune.model.combat.actions;

import com.g16.feyrune.interfaces.IAbilitable;
import com.g16.feyrune.model.combat.actions.abilities.BaseAbility;
import java.util.ArrayList;
import java.util.List;

public class AbilityFactory {

    /**
     * Creates a single ability
     * @param name Name of the ability
     * @param accuracy Accuracy of the ability
     * @param power Power of the ability
     * @return The created ability
     */
    public static BaseAbility createAbility(String name, int accuracy, int power) {
        return new BaseAbility(accuracy, power, name);
    }

    /**
     * Creates a list of abilities
     * @param names List of names of the abilities
     * @return The created list of abilities
     */
    public static List<IAbilitable> createAbilityList(String[] names) {
        List<IAbilitable> attacks = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            
            attacks.add(createAbilityByName(names[i]));
        }
        return attacks;
    }

    /**
     * Creates an ability by entering its name
     * @param name Name of the ability
     * @return The created ability
     */
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
