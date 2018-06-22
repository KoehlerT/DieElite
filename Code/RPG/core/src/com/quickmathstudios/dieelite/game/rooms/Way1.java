package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.interactables.Dog;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.player.Player;

public class Way1 extends Room {

    public Way1(){
        super("rooms/outside.png");

        Dog dog =new Dog(new Vector2(-100,100),new Vector2(1200,100),150f);
        Player.getInstance().setPosition(new Vector2(900,250));
        super.setInteractables(new Interactable[]{dog});
        CurrentDialogue.getInstance().addDialogue(new SimpleMessage("keiner mag mich ;(","player",null));
    }

}
