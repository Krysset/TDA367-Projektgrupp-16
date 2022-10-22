package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.overworld.OverworldModel;
import com.g16.feyrune.model.overworld.map.IMapObserver;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.overworld.textureMap.TextureMap;
import com.g16.feyrune.view.overworld.textureMap.TextureMapParser;
import com.g16.feyrune.view.player.PlayerRenderer;

public class OverworldScene implements IScene, IMapObserver {
    private PlayerRenderer pr;
    private SpriteBatch batch;
    private Camera camera;
    private TextureMap map;

    /**
     * Constructor for the OverworldScene
     * @param player the player
     * @param overworldModel the overworld model
     * @param batch the sprite batch to draw with
     */
    public OverworldScene(Player player, OverworldModel overworldModel, SpriteBatch batch){
        this.batch = batch;
        this.map = TextureMapParser.parseMapFile("maps/plains1.tmx");
        this.camera = new OrthographicCamera(270 ,135);
        pr = new PlayerRenderer(player);
        overworldModel.subscribeMapObserver(this);
    }


    /**
     * Renders the scene
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

    /**
     * Called when the map should be replaced
     * @param mapAssetPath the path to the new map
     */
    @Override
    public void updateMap(String mapAssetPath) {
        map = TextureMapParser.parseMapFile(mapAssetPath);
    }
}