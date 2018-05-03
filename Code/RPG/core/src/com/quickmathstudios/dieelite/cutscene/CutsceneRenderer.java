package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CutsceneRenderer {

    Cutscene cutscene;

    public CutsceneRenderer(Cutscene cutscene){
        this.cutscene = cutscene;
    }


    public void draw(SpriteBatch batch){
        batch.draw(cutscene.getTexture(),0,0);
    }
}
