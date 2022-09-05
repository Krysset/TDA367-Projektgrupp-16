package com.g16.feyrune.controller;

import com.g16.feyrune.map.Map;
import com.g16.feyrune.model.Player;

public class PlayerController {
    private PlayerInputHandler inputHandler;
    private Player player;
    private int moveFrequency;
    private int lastMoved = 0;

    public PlayerController(PlayerInputHandler inputHandler, Player player, int moveFrequency) {
        this.inputHandler = inputHandler;
        this.player = player;
        this.moveFrequency = moveFrequency;
    }

    public void UpdatePlayerPosition(int elapsedMS){
        if(elapsedMS - lastMoved < moveFrequency){
            return;
        }
        int dirX = inputHandler.getCurrentXDirection();
        int dirY = inputHandler.getCurrentYDirection();
        int newX = player.getPosX() + dirX;
        int newY = player.getPosY() + dirY;
        for (int i = 0; i < 3; i++){
            if(!IsNewPosCollision(newX,newY)){
                if(IsCorner(player.getPosX(), player.getPosY(), dirX,dirY)){
                    newX = player.getPosX();
                    newY = player.getPosY();
                }
                break;
            }
            switch (i){
                case 0:
                    newX = player.getPosX();
                    newY = player.getPosY() + dirY;
                case 1:
                    newX = player.getPosX() + dirX;
                    newY = player.getPosY();
                case 2:
                    newX = player.getPosX();
                    newY = player.getPosY();
            }
        }
        player.move(newX - player.getPosX(),newY - player.getPosY());
        lastMoved = elapsedMS;
    }

    private boolean IsCorner(int posX, int posY, int dirX, int dirY){
        if (dirX != 0 && dirY != 0){
            if (IsNewPosCollision(posX + dirX, posY) &&
                    IsNewPosCollision(posX, posY + dirY )){
                return true;
            }
        }
        return false;
    }

    public boolean IsNewPosCollision(int newX, int newY){
        return Map.getGlobalMap().getTile(newX,newY).hasCollision();
    }
}
