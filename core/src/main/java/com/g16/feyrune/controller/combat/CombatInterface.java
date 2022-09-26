package com.g16.feyrune.controller.combat;

import com.g16.feyrune.controller.CombatInputHandler;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.player.Player;

public class CombatInterface {
    private UIRenderer uiRenderer;
    private CombatInputHandler combatInputHandler;
    public CombatInterface(Encounter encounter, Player player) {
        uiRenderer =  new UIRenderer(encounter,player);
        combatInputHandler = new CombatInputHandler();
    }
}
