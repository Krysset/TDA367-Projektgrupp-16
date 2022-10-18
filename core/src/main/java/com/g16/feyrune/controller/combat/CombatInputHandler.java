package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.model.combat.actions.AttackAction;
import com.g16.feyrune.model.combat.actions.FleeAction;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;

import java.awt.*;

public class CombatInputHandler {
    private int currentSelection;
    private int[][] selectionArray;
    private final Point selectionPoint;
    private final PlayerCreature playerCreature;

    /**
     * Constructor for CombatInputHandler
     * @param playerCreature the playerCreature
     */
    public CombatInputHandler(PlayerCreature playerCreature) {
        currentSelection = 0;
        initSelectionArray();
        selectionPoint = new Point(0, 0);
        this.playerCreature = playerCreature;
    }

    /**
     * Initializes the selectionArray
     */
    private void initSelectionArray() {
        selectionArray = new int[][]{{0,1},{2,3}};
    }

    /**
     * Changes the currentSelection
     * @param direction in which direction the selection should be changed
     */
    public void changeSelection(Direction direction) {
        switch (direction) {
            case LEFT:
                selectionPoint.x = (selectionPoint.x-1)% selectionArray.length;
                break;
            case UP:
                selectionPoint.y = (selectionPoint.y-1)% selectionArray[0].length;
                break;
            case DOWN:
                selectionPoint.y = (selectionPoint.y+1)% selectionArray[0].length;
                break;
            case RIGHT:
                selectionPoint.x = (selectionPoint.x+1)% selectionArray.length;
                break;
            case BACK:
        }
        currentSelection = selectionArray[selectionPoint.y][selectionPoint.x];
    }

    /**
     * Returns the currentSelection
     * @return the currentSelection
     */
    public int getCurrentSelection() {
        return currentSelection;
    }

    /**
     * Initializes which action should be performed by which selection
     */
    public void excecuteSelection() {
        switch (currentSelection) {
            case 0:
                playerCreature.setSelectedAction(new AttackAction());
                break;
            case 3:
                playerCreature.setSelectedAction(new FleeAction());
                break;
            default:
                break;
        }
    }


}
