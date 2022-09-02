package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.g16.feyrune.interfaces.Observer;
import com.g16.feyrune.view.scenes.BattleScene;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BattleScene battleScene;

	public class Helu implements Observer {
		public Helu(){
			super();
		}
		@Override
		public void update() {
			System.out.println("helu");
		}
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Helu[] h ={new Helu(), new Helu()};
		battleScene = new BattleScene(800, 600, h);

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		battleScene.render(25);
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
