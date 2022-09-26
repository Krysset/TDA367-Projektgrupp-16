package com.g16.feyrune.view.combat;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.controller.combat.CombatInterface;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;
import com.g16.feyrune.view.IScene;

public class CombatScene implements IScene {

    //TODO: the relation for this object to the controller.
    private CombatInterface combatRenderer;

    public CombatScene() {
    }

    public void renderNewCombat(Encounter encounter, Player player){
        combatRenderer = new CombatInterface(encounter, player);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(SpriteBatch batch) {
        //TODO: NOT IMPLEMENTED
    }
}

