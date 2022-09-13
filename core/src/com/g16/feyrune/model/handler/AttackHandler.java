package com.g16.feyrune.model.handler;

import com.g16.feyrune.model.action.BaseAttack;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.Random;

public class AttackHandler {

    private static final Random randomCheck=new Random();

    /**
     * Used to make a monster attack another monster
     * @param attacker The monster performing the attack
     * @param defender The monster trying to evade the attack
     * @param baseAttack The specific attack being used
     */
    public static void handleAttack(BaseCreature attacker, BaseCreature defender, BaseAttack baseAttack){
        if (evasiveManoeuvre(defender, baseAttack)){
            double damage = calculateDamage(attacker, baseAttack);
            defender.damageMonster(damage);
        }
    }

    /**
     * Calculates the damage done by an attack
     * @param attacker: creature containing the attack used in the action
     * @param baseAttack: the attack action used against the defender
     * @return damage dealt to the defender (only calculates, doesn't deal it)
     */
    private static double calculateDamage(BaseCreature attacker, BaseAttack baseAttack){
        double damage = attacker.getAttack() * baseAttack.getPower();
        return damage;
    }

    /**
     * Calculates whether the attack accuracy is high enough to hit and whether the defender's evasiveness is high enough to evade it
     * @param defender: monster trying to evade the attack
     * @param baseAttack: attack to check accuracy on.
     * @return if attack is successful: true, if it misses false
     */
    private static boolean evasiveManoeuvre(BaseCreature defender, BaseAttack baseAttack){
        boolean evasion = defender.getEvasion()<randomCheck.nextInt(100);
        boolean accuracy = baseAttack.getAccuracy()>randomCheck.nextInt(100);
        boolean hit= evasion && accuracy;
        return hit;
    }
}
