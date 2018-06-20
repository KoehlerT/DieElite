package com.quickmathstudios.dieelite.game.dialogueEngine.dialogue;

import com.badlogic.gdx.graphics.Texture;

public class SimpleMessage extends Message {

    public SimpleMessage(String message, String aliasId, Message following) {
        super(message, aliasId, new Message[]{following}, new String[]{"weiter"});
    }
}
