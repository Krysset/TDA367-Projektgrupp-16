package com.g16.feyrune.model.handler;

import com.g16.feyrune.Util.Pair;
import com.g16.feyrune.model.action.BaseAttack;
import com.g16.feyrune.model.creature.BaseCreature;

public class BattleHandler {
    private BaseCreature friend;
    private BaseCreature enemy;

    private boolean combatIsActive = false;

    public void initBattle(BaseCreature friend, BaseCreature enemy) {
        this.friend = friend;
        this.enemy = enemy;
        this.combatIsActive = true;
    }

    public Pair<BaseCreature, BaseCreature> getOrderFromSpeed(BaseCreature friend, BaseCreature enemy) {
        BaseCreature fastest;
        BaseCreature slowest;
        Pair<BaseCreature, BaseCreature> order;

        if (friend.getSpeed() >= enemy.getSpeed()) {
            order = new Pair<>(friend, enemy);
        } else {
            order = new Pair<>(enemy, friend);
        }

        return order;
    }

    private BaseAttack getMove(BaseCreature toGetFrom) {
        return (toGetFrom.isFriend()) ? chooseMove() : null;
    }

    private BaseAttack chooseMove() {
        System.out.println("choose move");
        String chosenMove = "attackname"; //replace with the listener from the UI
        BaseAttack chosenAttacker = null; // don't know how to find what move is choosen
        return chosenAttacker;
    }

    private void battleLoop(BaseCreature friend, BaseCreature enemy) {
        /**
         * This method, and accompanying AttackHandler should probably be rewritten
         * to use a more generic battle loop with as little logic as possible.
         * 1. Get next
         * 2. Get move
         * 3. Execute move
         */
        Pair<BaseCreature, BaseCreature> order = getOrderFromSpeed(friend, enemy);
        BaseCreature fastest = order.fst;
        BaseCreature slowest = order.snd;

        int loop = 0;
        while (!combatIsActive) {
            BaseAttack playerMove = chooseMove();
            BaseAttack enemyMove = null; //random move

            if (fastest.isFriend()) {
                AttackHandler.handleAttack(fastest, slowest, playerMove);
                if (!combatIsActive) break;

                AttackHandler.handleAttack(slowest, fastest, enemyMove);
            } else {
                AttackHandler.handleAttack(fastest, slowest, enemyMove);
                if (!combatIsActive) break;
                AttackHandler.handleAttack(slowest, fastest, playerMove);
            }
        }

    }

    public static void exitBattle() {
    }

}
