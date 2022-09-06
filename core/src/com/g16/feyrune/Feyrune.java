package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.view.scenes.BattleScene;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	BattleScene bs;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bs= new BattleScene(1366,768,null);
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		bs.render(25);
		/*batch.begin();
		batch.draw(img, 0, 0);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
