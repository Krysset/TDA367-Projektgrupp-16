package com.g16.feyrune.view.overworld;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.IObserver;
import com.g16.feyrune.interfaces.IScene;
import com.g16.feyrune.model.Player;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.textureMap.TextureMap;
import com.g16.feyrune.view.textureMap.TextureMapParser;

import java.lang.annotation.Documented;

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
        camera.position.set(pr.getRenderPos().x * 16 + 8, pr.getRenderPos().y * 16 + 8, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        ScreenUtils.clear(textureMap.getBackgroundColor());
        batch.begin();
        textureMap.draw(batch);
        pr.draw(batch);
        batch.end();
    }
}
