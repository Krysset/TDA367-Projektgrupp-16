package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.overworld.map.MapManager;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.overworld.textureMap.TextureMapManager;

public class OverworldScene implements IScene {
    private PlayerRenderer pr;
    private SpriteBatch batch;
    private Camera camera;
    private TextureMapManager map;


    public OverworldScene(Player player, MapManager mapManager, SpriteBatch batch){
        this.batch = batch;
        this.map = new TextureMapManager(mapManager);
        this.camera = new OrthographicCamera(180 ,90);
        pr = new PlayerRenderer(player);
    }

    @Override
    public void update(){}

    @Override
    public void render(){
        camera.position.set(
                pr.getRenderPos().x * map.getTileSize() + map.getTileSize() / 2,
                pr.getRenderPos().y * map.getTileSize() + map.getTileSize() / 2,
                0);
        // Tells camera to recalculate what it sees
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(map.getBgColor());
        batch.begin();
        map.render(batch);
        pr.draw(batch);
        batch.end();
    }


}
