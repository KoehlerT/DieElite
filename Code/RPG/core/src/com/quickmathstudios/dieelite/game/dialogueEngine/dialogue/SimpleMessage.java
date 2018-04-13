package com.quickmathstudios.dieelite.game.dialogueEngine.dialogue;

import com.badlogic.gdx.graphics.Texture;

public class SimpleMessage extends Message {

    public SimpleMessage(String message, Texture personAlias, Message following) {
        super(message, personAlias, new Message[]{following}, new String[]{"weiter"});
    }
}
