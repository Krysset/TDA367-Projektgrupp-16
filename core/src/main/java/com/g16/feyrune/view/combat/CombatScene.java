package com.g16.feyrune.view.combat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.g16.feyrune.controller.combat.CombatRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.combat.CombatModel;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.model.overworld.encounter.Encounter;

public class CombatScene implements IScene { //TODO: the relation for this object to the controller.

    SpriteBatch batch;
    CombatGraphicsRenderer combatRenderer;
    private Camera camera;
    public CombatScene(SpriteBatch batch) {
        this.batch = batch;
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

    }

    public void renderNewCombat(CombatModel combatModel, Player player){
        combatRenderer = new CombatGraphicsRenderer(combatModel.getEnemyCreature(), player);
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {//TODO: NOT IMPLEMENTED
        //batch.setProjectionMatrix(camera.projection);
        ScreenUtils.clear(Color.CYAN);
        batch.begin();
        batch.draw(new Texture(Gdx.files.internal("assets/ui/choiceDialog.png")),0 - Gdx.graphics.getWidth()/2,0 - Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        combatRenderer.render(batch);
        batch.end();
    }
}

