package com.quickmathstudios.dieelite.loadingScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.quickmathstudios.dieelite.game.GameState;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.State;

public class loadingState implements State {


    private float time = 0f;
    private Animation<TextureRegion> animation;
    private Texture spriteSheet;
    private Texture background;

    @Override
    public void Show() {
        spriteSheet = new Texture("loadingSheet.png");
        background = new Texture("loadingback.png");
        TextureRegion[] tr = TextureRegion.split(spriteSheet,
                spriteSheet.getWidth()/8,
                spriteSheet.getHeight()/1)[0];
        animation = new Animation<TextureRegion>(0.125f,tr);
    }

    @Override
    public void Render(SpriteBatch batch) {
        batch.draw(background,0,0);
        batch.draw(animation.getKeyFrame(time,true),1100,100);
    }

    @Override
    public void Update(float delta) {
        time+=delta;
        if (time >= 2){
            finished();
        }
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
        background.dispose();
    }

    public void finished(){
        StateEngine.getInstance().SwitchState(new GameState());
    }
}
