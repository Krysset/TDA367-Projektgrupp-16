package com.g16.feyrune.model.handler;

import com.badlogic.gdx.utils.compression.lzma.Base;
import com.g16.feyrune.model.action.Attack;
import com.g16.feyrune.model.creature.BaseCreature;
import org.graalvm.compiler.lir.aarch64.AArch64Move;

import java.util.List;

public class BattleHandler {
    // will be used to collect which monster the player uses private Player p;
    private BaseCreature friend;
    private BaseCreature enemy;
    //opponent
    //private byte friendSlot;
    private boolean running = false;

    public void InitBattle(BaseCreature friend, BaseCreature enemy) {
        this.friend = friend;
        this.enemy = enemy;

        //this.opponent = opponent
        //friendSlot =0;
        this.running = true;
        //switch screen to battle screen
    }

    public BaseCreature[] CompareSpeed(BaseCreature friend, BaseCreature enemy){
        BaseCreature fastest;
        BaseCreature slowest;

        if(friend.getSpeed()>= enemy.getSpeed()){
            fastest=friend;
            slowest=enemy;
        }
        else {
            fastest = enemy;
            slowest = friend;
        }
        BaseCreature[]returnlist = {fastest, slowest};
        return returnlist;
    }

    private Attack getMove(BaseCreature toGetFrom){
        return (toGetFrom.getFriend())?choosemove():null;
    }

    private Attack choosemove(){
        System.out.println("choose move");
        String choosenMove = "attackname"; //replace with the listener from the UI
        Attack choosenAttack = null; // don't know how to find what move is choosen
        return choosenAttack;
    }


    private void battleLoop(BaseCreature friend, BaseCreature enemy){
        BaseCreature[] order = CompareSpeed(friend, enemy);
        BaseCreature fastest = order[0];        //if (riktigt ful kod){ byt ut senare;}
        BaseCreature slowest = order[1];
        int loop=0;
        while(!running){
            Attack playerMove = choosemove();
            Attack enemyMove = null; //random move
            AttackHandler.handleAttack(order[loop%2],order[(loop+1)%2],getMove(order[loop%2]));
            loop=(loop+1)%2;
           /*
            if (fastest.getFriend()){
                AttackHandler.handleAttack(fastest,slowest,playerMove);
                if (!running){break;}

                AttackHandler.handleAttack(slowest,fastest,enemyMove);
            }
            else{
                AttackHandler.handleAttack(fastest,slowest,enemyMove);
                if (!running){break;}
                AttackHandler.handleAttack(slowest,fastest,playerMove);
            }*/


        }

    }

    public static void exitBattle(){}//switch screen

}
