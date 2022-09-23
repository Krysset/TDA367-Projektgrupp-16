package com.g16.feyrune.view.combat;

import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

public class CombatScene implements IScene { //TODO: the relation for this object to the controller.
    GraphicsRenderer graphicsRenderer;
    UIRenderer uiRenderer;
    public CombatScene(Encounter encounter, Player player) {
        graphicsRenderer = new GraphicsRenderer(encounter,player);
        uiRenderer =  new UIRenderer(encounter,player);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {//TODO: NOT IMPLEMENTED
    }
}

