package com.g16.feyrune.model.combat;


import com.g16.feyrune.interfaces.IAbilitable;

import com.g16.feyrune.Util.Random;
import com.g16.feyrune.interfaces.ICombatable;
import com.g16.feyrune.model.combat.creatures.CombatCreature;

public class AttackHandler {

    /**
     * Used to make a monster attack another monster
     *
     * @param attacker The monster performing the attack
     * @param defender The monster trying to evade the attack
     * @param attack   The specific attack being used
     */
    public static void handleAttack(ICombatable attacker, ICombatable defender, IAbilitable attack) {
        if (evasiveManoeuvre(defender, attack)) {
            int damage = attacker.calculateAttack(attack);
            defender.takeDamage(damage);
        }
    }

    /**
     * Calculates whether the attack accuracy is high enough to hit and whether
     * the defender's evasiveness is high enough to evade it
     *
     * @param defender:    monster trying to evade the attack
     * @param baseAbility: attack to check accuracy on.
     * @return if attack is successful: true, if it misses false
     */
    private static boolean evasiveManoeuvre(ICombatable defender, IAbilitable baseAbility) {
        boolean evasion = defender.getSpeed() < Random.randomInt(100);
        boolean accuracy = baseAbility.getAttackAccuracy() > Random.randomInt(100);
        boolean hit = evasion && accuracy;
        return hit;
    }
}
