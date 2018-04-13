package com.quickmathstudios.dieelite.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.utillity.State;

public class StateEngine {

    private static StateEngine instance;
    public static StateEngine getInstance(){return instance;}

    private State currentState;

    public StateEngine(){
        instance = this;
    }

    public void renderState(SpriteBatch b){
        if (currentState == null)
            return;
        float delta = Gdx.graphics.getDeltaTime();
        currentState.Update(delta);
        currentState.Render(b);
    }

    public void SwitchState(State next){
        if (currentState != null){
            currentState.dispose();
        }
        currentState = next;
        currentState.Show();
    }

    public void disposeEngine(){

    }
}
