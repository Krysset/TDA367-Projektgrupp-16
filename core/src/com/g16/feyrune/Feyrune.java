package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.view.scenes.Scene;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Scene current;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		current=new Scene(800,600);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		current.render(25);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
