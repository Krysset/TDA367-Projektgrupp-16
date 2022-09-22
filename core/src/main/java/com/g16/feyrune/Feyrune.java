package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.g16.feyrune.controller.Controller;
import com.g16.feyrune.controller.WorldInputProcessor;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.model.TimeService;
import com.g16.feyrune.view.View;

public class Feyrune extends ApplicationAdapter {
	SpriteBatch batch;



	private View view;
	private Model model;
	private Controller controller;
	@Override
	public void create () {
		TimeService.initialize();

		model = new Model();
		view = new View(model);
		controller = new Controller(model);
		controller.update();

		//Gdx.input.setInputProcessor(new WorldInputProcessor(model.getMovementHandler()));
	}

	@Override
	public void render () {
		// Update Game
		// Render prep
		// Tile size is 16, should be be getters though, +8 (half of tile size) to center camera
		model.update();
		view.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
