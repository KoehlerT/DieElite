package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.rooms.ButterOffice;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class ButterQuestion extends Interactable {
    Texture alias;

    public ButterQuestion(Vector2 position){
        super(new Texture("entities/butter.png"),
                position,
                null);
        alias = new Texture("entities/butterAlias.png");
    }

    @Override
    public void interact() {
        Message root = new Message("Was reimt sich auf \"schlecht?\"",alias,new Message[]{
                new ActionMessage("Richtig", alias, null, new Action() {
                    @Override
                    public void act() {
                        RoomChanger.getInstance().changeRoom(new ButterOffice()); //Prinzipiell unnötig!!!
                    }
                }),
                new SimpleMessage("Falsch, Schreiben lernt man nur durch Schreiben",alias,null)
        },new String[]{
                "Specht",
                "Ich kann kein Deutsch"
        });

        CurrentDialogue.getInstance().addDialogue(root);
    }

    @Override
    public void dispose() {
        alias.dispose();
        super.dispose();
    }
}
