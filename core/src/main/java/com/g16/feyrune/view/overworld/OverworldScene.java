package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.overworld.map.MapManager;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.overworld.textureMap.TextureMapManager;
import com.g16.feyrune.view.overworld.textureMap.TextureMapParser;
import com.g16.feyrune.view.player.PlayerRenderer;

public class OverworldScene implements IScene {
    private PlayerRenderer pr;
    private SpriteBatch batch;
    private Camera camera;
    private TextureMapManager map;

    /**
     * Constructor for the OverworldScene
     * @param player the player to render
     * @param mapManager the map manager to get the map from
     * @param batch the sprite batch to draw with
     */
    public OverworldScene(Player player, OverworldModel overworldModel, SpriteBatch batch){
        this.batch = batch;
        this.map = TextureMapParser.parseMapFile("assets/maps/plains1.tmx");
        this.camera = new OrthographicCamera(270 ,135);
        pr = new PlayerRenderer(player);
        overworldModel.subscribeMapObserver(this);
    }
    /**
     * Update function to comply with IScene
     */
    @Override
    public void update(){}

    /**
     * Renders the scene using the stored sprite batch
     */
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

    @Override
    public void updateMap(String mapAssetPath) {
        map = TextureMapParser.parseMapFile(mapAssetPath);
    }
}
