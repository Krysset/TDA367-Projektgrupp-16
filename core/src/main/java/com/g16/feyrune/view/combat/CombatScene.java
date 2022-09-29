package com.g16.feyrune.view.combat;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.controller.combat.CombatRenderer;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

public class CombatScene implements IScene { //TODO: the relation for this object to the controller.

    SpriteBatch batch;
    CombatRenderer combatRenderer;
    public CombatScene(SpriteBatch batch) {
        this.batch = batch;
    }

    public void renderNewCombat(Encounter encounter, Player player){
        combatRenderer = new CombatRenderer(encounter, player);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {//TODO: NOT IMPLEMENTED
    }
}

