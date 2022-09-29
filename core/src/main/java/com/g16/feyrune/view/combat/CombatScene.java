package com.g16.feyrune.view.combat;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.g16.feyrune.controller.combat.CombatRenderer;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

import java.util.ArrayList;

public class CombatScene implements IScene { //TODO: the relation for this object to the controller.

    SpriteBatch batch;
    GraphicsRenderer graphicsRenderer;
    public CombatScene(SpriteBatch batch) {
        this.batch = batch;
    }



    public void renderNewCombat(Encounter encounter, Player player, ArrayList<ICombatCreature>  combatCreatures){
        graphicsRenderer = new GraphicsRenderer(encounter, player, combatCreatures);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {//TODO: NOT IMPLEMENTED
        batch.begin();
        graphicsRenderer.render(batch);
        batch.end();
    }
}

