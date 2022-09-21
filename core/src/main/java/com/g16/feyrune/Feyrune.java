package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.controller.MapPlayerInputProcessor;
import com.g16.feyrune.model.Player;
import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.model.overworld.MovementHandler;
import com.g16.feyrune.model.overworld.map.Map;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.textureMap.TextureMap;
import com.g16.feyrune.view.textureMap.TextureMapParser;

import java.awt.*;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;
	TextureMap textureMap;
	Map map;

	OrthographicCamera camera;

	Player player;
	PlayerRenderer playerRenderer;
	MovementHandler movementHandler;
	@Override
	public void create () {
		TimeService.initialize();
		batch = new SpriteBatch();
		textureMap = TextureMapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
		map = Map.getGlobalMap();
		player = new Player("Test",new Point(0, 0)); // Should probably have method to get initial coordinates.
		playerRenderer = new PlayerRenderer(player);
		camera = new OrthographicCamera(180 ,90);
		movementHandler = new MovementHandler();
		Gdx.input.setInputProcessor(new MapPlayerInputProcessor(movementHandler));
	}

	@Override
	public void render () {
		// Update Game
		// Render prep
		// Tile size is 16, should be be getters though, +8 (half of tile size) to center camera
		camera.position.set(playerRenderer.getRenderPos().x * 16 + 8, playerRenderer.getRenderPos().y * 16 + 8, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		ScreenUtils.clear(textureMap.getBackgroundColor());
		batch.begin();
		textureMap.draw(batch);
		playerRenderer.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
