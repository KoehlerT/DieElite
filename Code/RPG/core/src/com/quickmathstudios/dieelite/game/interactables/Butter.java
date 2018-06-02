package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Butter extends Interactable {
    private Texture alias;

    public Butter(Vector2 position){
        super(new Texture("entities/butter.png"),
                new HitBox(position, new Vector2(100, 200).add(position)),
                new HitBox(position, new Vector2(150, 250).add(position)),
                null);
        this.position = position;
        alias = new Texture("entities/butterAlias.png");
    }

    private Message getDialogue(){
        Message root = new ActionMessage("Ruder Kevin", alias, null, new Action() {
            @Override
            public void act() {
                StoryEngine.getInstance().updateStory(1);
            }
        });

        if (StoryEngine.getInstance().getStep() > 1){
            //Ruderspiel fertig!
            if (StoryEngine.getInstance().getBranch() == 0){
                root = new ActionMessage("OMG, bsit du schlecht! Komm Freitag nach dem Unterricht in mein Büro", alias, null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                });
            }else{
                root = new ActionMessage("OMG, ich bin beeindruckt! Komm Freitag nach dem Unterricht in mein Büro", alias, null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                });
            }
        }



        return root;
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(getDialogue());
    }

    @Override
    public void dispose() {
        super.dispose();
        alias.dispose();
    }
}
