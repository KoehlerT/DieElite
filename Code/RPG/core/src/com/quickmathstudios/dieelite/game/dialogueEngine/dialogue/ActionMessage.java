package com.quickmathstudios.dieelite.game.dialogueEngine.dialogue;

import com.badlogic.gdx.graphics.Texture;
import com.quickmathstudios.dieelite.utillity.Action;

public class ActionMessage extends SimpleMessage {

    private Action messageEvent; //Event/ Action beim Beenden dieser Nachricht

    public ActionMessage(String message, Texture personAlias, Message following, Action action) {
        super(message, personAlias, following);
        messageEvent = action;
    }

    @Override
    public Message getFollowing(int choiceIndex){
        if (messageEvent != null){
            messageEvent.act();
        }

        return super.getFollowing(choiceIndex);
    }
}
