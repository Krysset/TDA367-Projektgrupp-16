package com.g16.feyrune.view.combat;

import com.g16.feyrune.enums.Direction;
import com.g16.feyrune.enums.Selection;

import java.util.ArrayList;

public class ChoiceRenderer {
    private Selection currentSelection;
    private ArrayList<ChoiceButton> buttons;

    public ChoiceRenderer(){ //TODO: there should be some logic here to select one of them
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
        buttons.add(new ChoiceButton());
    }

    public void render(){
        for (ChoiceButton button : buttons) {
            button.render(false);
        }
    }

    public void changeSelection(Direction direction){ //TODO: NOT IMPLEMENTED LOGIC, should have some relation to controller..
        switch (direction){
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
            case BACK:

        }

    }
    public Selection getCurrentSelection(){
        return currentSelection;
    }
}
