package com.quickmathstudios.dieelite.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.input.InputRegister;
import com.quickmathstudios.dieelite.mainMenu.MenuScreen;

public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	private StateEngine stateEngine;
	private InputRegister register;

	MenuScreen mainMenu;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		stateEngine = new StateEngine();
		mainMenu = new MenuScreen();
		register = new InputRegister();
		Gdx.input.setInputProcessor(register);
		stateEngine.SwitchState(mainMenu);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		stateEngine.renderState(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stateEngine.disposeEngine();
	}
}
