package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.textureMap.TextureMap;
import com.g16.feyrune.view.textureMap.TextureMapParser;

public class OverworldScene implements IScene, IObserver {
    private Player player;
    private PlayerRenderer pr;
    private SpriteBatch batch;
    private Camera camera;
    private TextureMap textureMap;

    public OverworldScene(Player player, SpriteBatch batch) {
        this.player = player;
        this.batch = batch;
        this.camera = new OrthographicCamera(180 ,90);
        pr = new PlayerRenderer(player);
        textureMap = TextureMapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(){
        camera.position.set(
                pr.getRenderPos().x * textureMap.getTileSize() + textureMap.getTileSize() / 2,
                pr.getRenderPos().y * textureMap.getTileSize() + textureMap.getTileSize() / 2,
                0);
        // Tells camera to recalculate what it sees
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(textureMap.getBackgroundColor());
        batch.begin();
        textureMap.draw(batch);
        pr.draw(batch);
        batch.end();
    }
}
