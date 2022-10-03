package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.interfaces.ICreature;
import com.g16.feyrune.model.combat.creatures.EnemyCreature;
import com.g16.feyrune.model.creature.BaseCreature;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

import java.util.ArrayList;

public class CombatGraphicsRenderer {
    private Player player;
    private ICreature enemyCreature;
    private HealthBar enemyHealthBar, playerHealthBar;
    private float posY = Gdx.graphics.getHeight()/2 - (Gdx.graphics.getHeight()/8);
    private float width = Gdx.graphics.getWidth() /8, height = Gdx.graphics.getHeight()/24;


    public CombatGraphicsRenderer(BaseCreature enemyCreature, Player player){

        this.player = player;
        this.enemyCreature = enemyCreature;
        enemyHealthBar = new HealthBar(enemyCreature.getHP(), Gdx.graphics.getWidth()/2-width, posY,width,height);
        playerHealthBar = new HealthBar((BaseCreature)(player.getCreature()).getHP(), -Gdx.graphics.getWidth()/2, posY,width,height);
    }

    public void render(Batch batch){
        //TODO: NOT IMPLEMENTED
        enemyHealthBar.setCurrentHealth(enemyCreature.getHP());
        playerHealthBar.setCurrentHealth(player.getCreature().getHP());

        enemyHealthBar.render(batch);
        playerHealthBar.render(batch);
    }

}
