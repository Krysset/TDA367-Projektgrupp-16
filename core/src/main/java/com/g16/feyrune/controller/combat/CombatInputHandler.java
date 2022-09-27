package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.enums.Direction;
import com.g16.feyrune.controller.enums.Selection;

import java.awt.*;

public class CombatInputHandler {
    private Selection currentSelection;
    private final Selection[][] selectionArray = new Selection[2][2];
    private Point selectionPoint;
    public CombatInputHandler(){
        currentSelection = Selection.FIRST;
        initSelectionArray();
        selectionPoint = new Point(0,0);
    }

    private void initSelectionArray(){
        selectionArray[0][0] = Selection.FIRST;
        selectionArray[0][1] = Selection.SECOND;
        selectionArray[1][0] = Selection.THIRD;
        selectionArray[1][1] = Selection.FOURTH;
    }

    public void changeSelection(Direction direction){
        switch (direction){
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
    public Selection getCurrentSelection(){
        return currentSelection;
    }
    public void excecuteSelection(){
        //TODO: notify correct observer with currentSelection
        System.out.println(currentSelection.toString());
    }
}
