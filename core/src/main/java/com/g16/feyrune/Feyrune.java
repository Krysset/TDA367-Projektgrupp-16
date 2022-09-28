package com.g16.feyrune;

import com.badlogic.gdx.ApplicationAdapter;
import com.g16.feyrune.controller.Controller;
import com.g16.feyrune.model.Model;
import com.g16.feyrune.view.View;

public class Feyrune extends ApplicationAdapter {
	private View view;
	private Model model;
	private Controller controller;

	@Override
	public void create () {
		model = new Model();
		view = new View(model);
		controller = new Controller(model, view);
	}

	@Override
	public void render () {
		model.update();

		view.render();
		controller.render(view.getBatch());
	}
	
	@Override
	public void dispose () {
	}
}
