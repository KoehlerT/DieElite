package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.input.MouseInfo;
import com.quickmathstudios.dieelite.loadingScreen.loadingState;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;
import com.quickmathstudios.dieelite.utillity.State;

public class MenuScreen implements State, Observer {

    Texture background;

    @Override
    public void Show() {
        background = new Texture("menuback.png");
        MouseInfo.getInstance().addObserver(this);
    }

    @Override
    public void Render(SpriteBatch batch) {
        batch.draw(background,0,0);
    }

    @Override
    public void Update(float delta) {

    }

    @Override
    public void dispose() {
        background.dispose();
        MouseInfo.getInstance().deleteObserver(this);
    }

    @Override
    public void Update(Observable observable, Object sender) {
        //Es wurde geklickt
        //State newState = new GameState();
        State newState = new loadingState();
        this.dispose();
        StateEngine.getInstance().SwitchState(newState);
    }
}
