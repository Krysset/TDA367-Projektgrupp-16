package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.combat.UIRenderer;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.combat.GraphicsRenderer;

public class CombatRenderer {
    UIRenderer uiRenderer;
    CombatInputHandler combatInputHandler;
    public CombatRenderer(Encounter encounter, Player player) {
        uiRenderer =  new UIRenderer(encounter,player);
        combatInputHandler = new CombatInputHandler();
    }
}
