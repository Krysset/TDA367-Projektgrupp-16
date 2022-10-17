package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.controller.enums.Selection;
import com.g16.feyrune.model.combat.actions.AttackAction;
import com.g16.feyrune.model.combat.actions.FleeAction;
import com.g16.feyrune.model.combat.creatures.PlayerCreature;

import java.awt.*;

public class CombatInputHandler {
    private Selection currentSelection;
    private final Selection[][] selectionArray = new Selection[2][2];
    private final Point selectionPoint;
    private final PlayerCreature playerCreature;

    /**
     * Constructor for CombatInputHandler
     * @param playerCreature the playerCreature
     */
    public CombatInputHandler(PlayerCreature playerCreature) {
        currentSelection = Selection.FIRST;
        initSelectionArray();
        selectionPoint = new Point(0, 0);
        this.playerCreature = playerCreature;
    }

    /**
     * Initializes the selectionArray
     */
    private void initSelectionArray() {
        selectionArray[0][0] = Selection.FIRST;
        selectionArray[0][1] = Selection.SECOND;
        selectionArray[1][0] = Selection.THIRD;
        selectionArray[1][1] = Selection.FOURTH;
    }

    /**
     * Changes the currentSelection
     * @param direction in which direction the selection should be changed
     */
    public void changeSelection(Direction direction) {
        switch (direction) {
            case LEFT:
                selectionPoint.x = selectionPoint.x == 0 ? 1 : 0;
                break;
            case UP:
                selectionPoint.y = selectionPoint.y == 0 ? 1 : 0;
                break;
            case DOWN:
                selectionPoint.y = selectionPoint.y == 1 ? 0 : 1;
                break;
            case RIGHT:
                selectionPoint.x = selectionPoint.x == 1 ? 0 : 1;
                break;
            case BACK:
        }
        currentSelection = selectionArray[selectionPoint.y][selectionPoint.x];
    }

    /**
     * Returns the currentSelection
     * @return the currentSelection
     */
    public Selection getCurrentSelection() {
        return currentSelection;
    }

    /**
     * Initializes which action should be performed by which selection
     */
    public void excecuteSelection() {
        switch (currentSelection) {
            case FIRST:
                playerCreature.setSelectedAction(new AttackAction());
                break;
            case FOURTH:
                playerCreature.setSelectedAction(new FleeAction());
                break;
            default:
                break;
        }
    }


}
