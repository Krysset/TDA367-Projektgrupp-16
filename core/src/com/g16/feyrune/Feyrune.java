package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.model.Player;
import com.g16.feyrune.model.map.parser.Map;
import com.g16.feyrune.view.player.PlayerRenderer;
import com.g16.feyrune.view.textureMap.MapDrawer;
import com.g16.feyrune.view.textureMap.TextureMap;
import com.g16.feyrune.view.textureMap.TextureMapParser;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;
	TextureMap textureMap;
	Map map;
	Player player;
	PlayerRenderer playerRenderer;
	OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureMap = TextureMapParser.parseMapFile("assets/maps/dungeon/dungeon1.tmx");
		map = Map.getGlobalMap();
		player = new Player("Test",5,5);
		playerRenderer = new PlayerRenderer(player);
		camera = new OrthographicCamera(180 ,90);
	}

	@Override
	public void render () {
		// Render prep
		// Tile size is 16, should be be getters though, +8 (half of tile size) to center camera
		camera.position.set(player.getPosX() * 16 + 8, player.getPosY() * 16 + 8, 0);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		ScreenUtils.clear(textureMap.getBackgroundColor());
		batch.begin();
		MapDrawer.drawMap(batch, map, textureMap.getTilesets());
		playerRenderer.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
