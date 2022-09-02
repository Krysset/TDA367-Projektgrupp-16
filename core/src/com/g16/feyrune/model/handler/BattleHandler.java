package com.g16.feyrune.model.handler;

import com.g16.feyrune.model.creature.BaseCreature;
import org.graalvm.compiler.lir.aarch64.AArch64Move;

public class BattleHandler {
    // will be used to collect which monster the player uses private Player p;
    private BaseCreature friend;
    private BaseCreature enemy;
    //opponent
    //private byte friendSlot;
    private boolean running;

    public void Battle(BaseCreature friend, BaseCreature enemy) {
        this.friend = friend;
        this.enemy = enemy;

        //this.opponent = opponent
        //friendSlot =0;
        this.running = true;
    }
    public





    public static void initBattle(){}//switch screen

    public static void battleLoop(){}

    public static void exitBattle(){}//switch screen

}
