package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.interactables.Butter;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Boathouse extends Room {
    public Boathouse() {
        super("rooms/boathouse.png");

        Interactable[] ints = new Interactable[2];

        ints[0] = new Butter(new Vector2(100,300));
        Vector2 ergometerPos = new Vector2(800,350);
        ints[1] = new Interactable(new Texture("objects/ergometer.png"),
                ergometerPos,
                null) {

            @Override
            public void interact() {
                if (StoryEngine.getInstance().getStep() != 1){
                    CurrentDialogue.getInstance().addDialogue(new SimpleMessage("Du darfst noch nicht",null,null));
                }else{
                    StoryEngine.getInstance().updateStory();
                }
            }
        };

        setInteractables(ints);
    }
}
