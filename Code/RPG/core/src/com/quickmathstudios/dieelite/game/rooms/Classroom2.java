package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.interactables.Arrow;
import com.quickmathstudios.dieelite.game.interactables.Bernweich;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.Action;

public class Classroom2 extends Room {


    public Classroom2() {
        super("klassenraumback.png");

        Interactable bernweich = new Bernweich(new Vector2(100,200));
        Interactable door = new Arrow(new Vector2(100, 30), new Action() {
            @Override
            public void act() {
                int step = StoryEngine.getInstance().getStep();
                if (step <= 1){
                    //Rätsel noch nicht bestanden
                    CurrentDialogue.getInstance().addDialogue(new SimpleMessage("Du bist noch nicht Fertig!",null,null));
                }else {
                    StoryEngine.getInstance().updateStory();
                }
            }
        },"D");

        super.setInteractables(new Interactable[]{bernweich,door});
    }
}
