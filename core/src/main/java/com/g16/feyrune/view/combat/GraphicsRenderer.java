package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.g16.feyrune.interfaces.ICombatCreature;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

import java.util.ArrayList;
import java.util.List;

public class GraphicsRenderer {
    private Encounter encounter;
    private Player player;
    private List<HealthBar> healthBars;

    private float healthWidth = Gdx.graphics.getWidth()/4, healthHeight = Gdx.graphics.getHeight()/32;
    private Vector2 fHealthPos = new Vector2(0,Gdx.graphics.getHeight() - 50), eHealthPos = new Vector2(Gdx.graphics.getWidth() - healthWidth, Gdx.graphics.getHeight() - 50);

    public GraphicsRenderer(Encounter encounter, Player player, ArrayList<ICombatCreature> combatCreatures){
        this.encounter = encounter;
        this.player = player;
        healthBars = new ArrayList<>();
        healthBars.add(new HealthBar(combatCreatures.get(1).getHP(), eHealthPos.x,eHealthPos.y, healthWidth, healthHeight));
        healthBars.add(new HealthBar(combatCreatures.get(0).getHP(), fHealthPos.x, fHealthPos.y, healthWidth, healthHeight));
    }

    public void render(Batch batch){
        setHealthbars();
        for (HealthBar healthBar :
                healthBars) {
            healthBar.render(batch);
        }
        //TODO: NOT IMPLEMENTED
    }

    private void setHealthbars(){
        if (player.getCreature().getHP() != healthBars.get(0).getCurrentHealth()){
            healthBars.get(0).setCurrentHealth(player.getCreature().getHP());
        }
        if (player.getCreature().getHP() != healthBars.get(1).getCurrentHealth()){
            healthBars.get(1).setCurrentHealth(encounter.getEnemyCreature()[0].getHP());
        }
    }

}
