package com.quickmathstudios.dieelite.minigames.rowing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.utillity.State;

public class RowingState implements State {

    Minigame game;
    Controller controller;
    Renderer renderer;

    @Override
    public void Show() {
        game = new Minigame();
        controller = new Controller(game);
        renderer = new Renderer(game);
    }

    @Override
    public void Render(SpriteBatch batch) {
        renderer.Render(batch);
    }

    @Override
    public void Update(float delta) {
        controller.UpdateLogic(delta);
    }

    @Override
    public void dispose() {
        game.dispose();
        controller.dispose();
    }
}
