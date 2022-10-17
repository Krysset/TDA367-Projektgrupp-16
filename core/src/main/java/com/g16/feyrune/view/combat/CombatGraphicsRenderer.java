package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.g16.feyrune.model.combat.creatures.CombatCreature;
import com.g16.feyrune.model.player.Player;


public class CombatGraphicsRenderer {
    private Player player;
    private CombatCreature enemyCreature;
    private HealthBar enemyHealthBar, playerHealthBar;
    private CreatureRenderer enemyRenderer, playerRenderer;
    private float posY = Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/8);
    private float width = Gdx.graphics.getWidth() /6, height = Gdx.graphics.getHeight()/24;
    private float tolerance = Gdx.graphics.getWidth()/32;

    private float creaturePosY = Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/3);


    /**
     * Constructor for the CombatGraphicsRenderer
     * @param enemyCreature the enemy creature
     * @param player the player
     */
    public CombatGraphicsRenderer(CombatCreature enemyCreature, Player player){

        this.player = player;
        this.enemyCreature = enemyCreature;
        
        enemyHealthBar = new HealthBar(enemyCreature.getHP(), Gdx.graphics.getWidth()/2-width - tolerance, posY,width,height);
        playerHealthBar = new HealthBar(player.getPlayerCreature().getHP(), -Gdx.graphics.getWidth()/2 + tolerance, posY,width,height);
        playerRenderer = new CreatureRenderer(player.getPlayerCreature(),-Gdx.graphics.getWidth()/2 + tolerance, creaturePosY, false);
        enemyRenderer = new CreatureRenderer(enemyCreature,Gdx.graphics.getWidth()/2 - tolerance, creaturePosY, true);
    }

    /**
     * Renders the graphics
     * @param batch the batch to render on
     */
    public void render(Batch batch){
        //TODO: NOT IMPLEMENTED
        enemyHealthBar.setCurrentHealth(enemyCreature.getHP());
        playerHealthBar.setCurrentHealth(player.getPlayerCreature().getHP());

        enemyRenderer.render(batch);
        playerRenderer.render(batch);
        enemyHealthBar.render(batch);
        playerHealthBar.render(batch);
    }

}
