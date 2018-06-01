package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.utillity.State;

public class CutsceneState implements State {

    Cutscene scene;
    CutsceneRenderer renderer;
    CutsceneController controller;

    public CutsceneState(Cutscene toDisplay){
        scene = toDisplay;
    }

    @Override
    public void Show() {
        renderer = new CutsceneRenderer(scene);
        controller = new CutsceneController(scene);
    }

    @Override
    public void Render(SpriteBatch batch) {
        renderer.draw(batch);
    }

    @Override
    public void Update(float delta) {
        controller.updateLogic(delta);
    }

    @Override
    public void dispose() {
        scene.dispose();
        controller.dispose();
    }
}
