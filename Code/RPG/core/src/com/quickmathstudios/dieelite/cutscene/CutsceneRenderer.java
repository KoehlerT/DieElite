package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueRenderer;

public class CutsceneRenderer implements Disposable {

    Cutscene cutscene;
    DialogueRenderer renderer;

    public CutsceneRenderer(Cutscene cutscene){
        this.cutscene = cutscene;
        renderer = new DialogueRenderer();
    }


    public void draw(SpriteBatch batch){
        batch.draw(cutscene.getTexture(),0,0);
        renderer.draw(batch);
    }


    @Override
    public void dispose() {
        renderer.dispose();
    }
}
