package com.g16.feyrune.model.handler;

import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.model.action.BaseAttack;
import com.g16.feyrune.model.creature.BaseCreature;

import java.util.ArrayList;

public class BattleHandler {
    private BaseCreature friend;
    private BaseCreature enemy;
    private ArrayList<BaseCreature> turnOrder;
    private boolean combatIsActive = false;

    private int friendSpeed;
    private int enemySpeed;
    private int speedThreshold = 250;

    /**
     * Constructor for the BattleHandler class
     *
     * @param friend: the player's monster
     * @param enemy:  the enemy monster
     */
    public void startBattle(BaseCreature friend, BaseCreature enemy) {
        turnOrder = new ArrayList<BaseCreature>();
        this.friend = friend;
        this.enemy = enemy;
        generateNewAttackOrder();
        combatIsActive = true;

    }

    /**
     * Generates a new turn order for the battle
     */
    private void generateNewAttackOrder() {
        friendSpeed = 0;
        enemySpeed = 0;
        generateAttackOrder();

    }

    /**
     * Adds turns to the turn order
     */
    private void generateAttackOrder() {
        while (turnOrder.size() < 10) {
            friendSpeed += friend.getSpeed();
            if (friendSpeed > speedThreshold) {
                friendSpeed -= speedThreshold;
                turnOrder.add(friend);
            }

            enemySpeed += enemy.getSpeed();
            if (enemySpeed > speedThreshold) {
                enemySpeed -= speedThreshold;
                turnOrder.add(enemy);
            }
        }
    }

    /**
     * For now, the exact same as EnemyAttack, when implementing player input this should be redone.
     */
    private void friendChooseAttack() {
        BaseAttack[] attacks = friend.getAttacks();
        int attackIndex = (int) (Math.random() * attacks.length);
        BaseAttack currentAttack = attacks[attackIndex];
        useAttack(friend, enemy, currentAttack);
    }

    /**
     * Chooses an attack for the enemy
     */
    private void enemyChooseAttack() {
        BaseAttack[] enemyAttacks = enemy.getAttacks();
        int attackIndex = (int) (Math.random() * enemyAttacks.length);
        BaseAttack currentAttack = enemyAttacks[attackIndex];
        useAttack(enemy, friend, currentAttack);
    }

    /**
     * Controls which creature should attack and makes them choose one
     */
    private void chooseAttack() {
        BaseCreature currentMonster = turnOrder.remove(0);
        if (currentMonster.isFriend()) friendChooseAttack();
        else enemyChooseAttack();
        generateAttackOrder();
    }

    /**
     * Uses an attack through the attack handler
     *
     * @param attacker:    the creature that is attacking
     * @param defender:    the creature that is being attacked
     * @param attackToUse: the attack that is being used
     */
    private void useAttack(BaseCreature attacker, BaseCreature defender, BaseAttack attackToUse) {
        AttackHandler.handleAttack(attacker, defender, attackToUse);
    }

    /**
     * Checks if the battle is over, if not, continues the battle
     */
    private void battleLoop() {
        while (combatIsActive) {
            chooseAttack();
        }
    }

}
