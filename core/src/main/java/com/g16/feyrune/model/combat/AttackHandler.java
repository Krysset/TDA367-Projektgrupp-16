package com.g16.feyrune.model.combat;

import com.g16.feyrune.model.combat.creatures.ICombatCreature;
import com.g16.feyrune.model.combat.ability.IAbility;

import com.g16.feyrune.Util.Random;

public class AttackHandler {

    /**
     * Used to make a monster attack another monster
     * @param attacker The monster performing the attack
     * @param defender The monster trying to evade the attack
     * @param attack The specific attack being used
     */
    public static void handleAttack(ICombatCreature attacker, ICombatCreature defender, IAbility attack){
        if (evasiveManoeuvre(defender, attack)){
            int damage = calculateDamage(attacker, attack);
            defender.takeDamage(damage);
        }
    }

    /**
     * Calculates the damage done by an attack
     * @param attacker: creature containing the attack used in the action
     * @param attack: the attack action used against the defender
     * @return damage dealt to the defender (only calculates, doesn't deal it)
     */
    private static int calculateDamage(ICombatCreature attacker, IAbility attack){
        return attacker.getPower() * attack.getAttackPower();
    }

    /**
     * Calculates whether the attack accuracy is high enough to hit and whether the defender's evasiveness is high enough to evade it
     * @param defender: monster trying to evade the attack
     * @param baseAttack: attack to check accuracy on.
     * @return if attack is successful: true, if it misses false
     */
    private static boolean evasiveManoeuvre(ICombatCreature defender, IAbility baseAttack){
        boolean failedEvade = defender.getSpeed() < Random.random.nextInt(100);
        boolean successHit = baseAttack.getAttackAccuracy() > Random.random.nextInt(100);
        return failedEvade && successHit;
    }
}
