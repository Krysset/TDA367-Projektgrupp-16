package com.g16.feyrune.controller.combat;

import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

public class UIRenderer {
    //TODO: NOT IMPLEMENTED graphics for this object
    private HealthBar fHealthBar, eHealthBar;
    private ChoiceRenderer choiceRenderer;
    public UIRenderer(Encounter encounter, Player player){
        choiceRenderer = new ChoiceRenderer();

        eHealthBar = new HealthBar((int)encounter.getEnemyCreature()[0].getHP());
        fHealthBar = new HealthBar((int)player.getCreature().getHP());
    }

    public void render(){
        eHealthBar.render();
        fHealthBar.render();
    }
}
