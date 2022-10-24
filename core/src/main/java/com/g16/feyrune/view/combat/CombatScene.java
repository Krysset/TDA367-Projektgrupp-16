package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.player.Player;

public class CombatScene implements IScene { //TODO: the relation for this object to the controller.

    SpriteBatch batch;
    CombatGraphicsRenderer combatRenderer;
    private Camera camera;

    /**
     * Constructor for the CombatScene
     * @param batch the batch to render on
     */
    public CombatScene(SpriteBatch batch) {
        this.batch = batch;
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    /**
     *  Renders the scene
     * @param combatModel the combat model to render data from
     * @param player the player to render data from
     */
    public void renderNewCombat(CombatModel combatModel, Player player){
        combatRenderer = new CombatGraphicsRenderer(combatModel.getEnemyCreature(), player);
    }

    /**
     * Renders the scene
     */
    @Override
    public void render() {//TODO: NOT IMPLEMENTED
        ScreenUtils.clear(Color.CYAN);
        batch.begin();
        combatRenderer.render(batch);
        batch.end();
    }
}

