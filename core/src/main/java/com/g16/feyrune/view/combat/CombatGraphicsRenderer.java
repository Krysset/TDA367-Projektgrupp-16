package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

import java.util.ArrayList;

public class CombatGraphicsRenderer {
    private Player player;
    private ICreature enemyCreature;
    private HealthBar enemyHealthBar, playerHealthBar;
    private CreatureRenderer enemyRenderer, playerRenderer;
    private float posY = Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/8);
    private float width = Gdx.graphics.getWidth() /8, height = Gdx.graphics.getHeight()/24;

    private float creaturePosY = Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/8);



    public CombatGraphicsRenderer(ICreature enemyCreature, Player player){

        this.player = player;
        this.enemyCreature = enemyCreature;
        enemyHealthBar = new HealthBar(enemyCreature.getHP(), Gdx.graphics.getWidth()/2-width, posY,width,height);
        playerHealthBar = new HealthBar(player.getCreature().getHP(), -Gdx.graphics.getWidth()/2, posY,width,height);
        playerRenderer = new CreatureRenderer(player.getCreature(),-Gdx.graphics.getWidth()/2 + 10, creaturePosY, false);

        enemyRenderer = new CreatureRenderer(enemyCreature,Gdx.graphics.getWidth()/4, creaturePosY, true);
    }

    public void render(Batch batch){
        //TODO: NOT IMPLEMENTED
        enemyHealthBar.setCurrentHealth(enemyCreature.getHP());
        playerHealthBar.setCurrentHealth(player.getCreature().getHP());

        enemyRenderer.render(batch);
        playerRenderer.render(batch);
        enemyHealthBar.render(batch);
        playerHealthBar.render(batch);
    }

}
