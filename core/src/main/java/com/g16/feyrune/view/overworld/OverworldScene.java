package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.player.Player;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.overworld.textureMap.TextureMap;
import com.g16.feyrune.view.overworld.textureMap.TextureMapParser;

public class OverworldScene implements IScene, IObserver {
    private Player player;
    private PlayerRenderer pr;
    private SpriteBatch batch;
    private Camera camera;
    private TextureMap textureMap;


    public OverworldScene(Player player, SpriteBatch batch, Camera camera){
        this.player = player;
        this.batch = batch;
        this.camera = camera;
        pr = new PlayerRenderer(player);
        textureMap = TextureMapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(){
        // Tile size is 16, should be be getters though, +8 (half of tile size) to center camera
        camera.position.set(pr.getRenderPos().x * 16 + 8, pr.getRenderPos().y * 16 + 8, 0);
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
