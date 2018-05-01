package com.quickmathstudios.dieelite.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.input.InputRegister;
import com.quickmathstudios.dieelite.mainMenu.MenuScreen;
/**
 * Diese Klasse erbt von Spiel und gibt uns Kontrolle über die Engine
 * **/
public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;

	private StateEngine stateEngine; //Kontrolliert den GameState
	private InputRegister register;  //Anspruchpartner für Benutzereingabem

	MenuScreen mainMenu;

	/**
	 * Wichtigste Objekte werden instanziiert
	 * **/
	@Override
	public void create () {
		batch = new SpriteBatch();
		stateEngine = new StateEngine();
		mainMenu = new MenuScreen();
		register = new InputRegister();
		Gdx.input.setInputProcessor(register);
		stateEngine.SwitchState(mainMenu);

	}

	/**Die Render Methode. Von der Engine die einzige Methode, die frameweise aufgerufen wird
	 * **/
	@Override
	public void render () {
		//Bildschirm leeren
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//Die Stateengine wird ab jetzt das zu Rendernde Objekt auswählen
		stateEngine.renderState(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		//Freigabe von Arbeitsspeicher
		batch.dispose();
		stateEngine.disposeEngine();
	}
}
