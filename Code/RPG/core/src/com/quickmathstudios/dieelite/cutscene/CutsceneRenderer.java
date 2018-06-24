package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueRenderer;

public class CutsceneRenderer implements Disposable {

    Cutscene cutscene;
    DialogueRenderer renderer;
    Texture Overlay;

    public CutsceneRenderer(Cutscene cutscene){
        this.cutscene = cutscene;
        Overlay = new Texture("misc/cutsceneOverlay.png");
        renderer = new DialogueRenderer();
    }


    public void draw(SpriteBatch batch){
        batch.draw(cutscene.getTexture(),0,0);
        renderer.draw(batch);
        if (cutscene.finished()){
            batch.draw(Overlay,0,0);
        }
    }


    @Override
    public void dispose() {
        Overlay.dispose();
        renderer.dispose();
    }
}
