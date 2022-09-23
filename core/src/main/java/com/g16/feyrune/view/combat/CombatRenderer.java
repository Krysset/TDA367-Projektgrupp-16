package com.g16.feyrune.view.combat;

import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.model.player.Player;

public class CombatRenderer {
    private GraphicsRenderer graphicsRenderer;
    private UIRenderer uiRenderer;
    private CombatInputHandler combatInputHandler;
    public CombatRenderer(Encounter encounter, Player player) {
        graphicsRenderer = new GraphicsRenderer(encounter,player);
        uiRenderer =  new UIRenderer(encounter,player);
        combatInputHandler = new CombatInputHandler();
    }
}
