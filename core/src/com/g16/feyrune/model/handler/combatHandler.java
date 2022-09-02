package com.g16.feyrune.model.handler;

import com.g16.feyrune.model.action.Attack;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.Random;

public class combatHandler {

    private static final Random randomCheck=new Random();

    /**
     * Used to make a monster attack another monster
     * @param attacker The monster performing the attack
     * @param defender The monster trying to evade the attack
     * @param attack The specific attack being used
     */
    public static void handleAttack(BaseCreature attacker, BaseCreature defender, Attack attack){
        if (evasiveManoeuvre(defender, attack)){
            double damage = calculateDamage(attacker, attack);
            defender.damageMonster(damage);
        }
    }

    /**
     *
     * @param attacker: creature containing the attack used in the action
     * @param attack: the attack action used against the defender
     * @return damage dealt to the defender (only calculates, doesn't deal it)
     */
    private static double calculateDamage(BaseCreature attacker, Attack attack){
        double damage = attacker.getAttack() * attack.getPower();
        return damage;
    }

    /**
     * Calculates whether the attack accuracy is high enough to hit and whether the defender's evasiveness is high enough to evade it
     * @param defender: monster trying to evade the attack
     * @param attack: attack to check accuracy on.
     * @return if attack is successful: true, if it misses false
     */
    private static boolean evasiveManoeuvre(BaseCreature defender, Attack attack){
        boolean evasion = defender.getEvasion()<randomCheck.nextInt(100);
        boolean accuracy = attack.getAccuracy()>randomCheck.nextInt(100);
        boolean hit= evasion && accuracy;
        return hit;
    }
}
