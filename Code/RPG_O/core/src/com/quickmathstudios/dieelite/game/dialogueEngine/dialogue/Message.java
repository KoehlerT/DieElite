package com.quickmathstudios.dieelite.game.dialogueEngine.dialogue;

import com.badlogic.gdx.graphics.Texture;

public class Message {

    private Message[] followings;
    private String[] options;
    private Texture alias;
    private String content;

    public Message(String message, Texture personAlias, Message[] following, String[] options) {
        content = message;
        alias = personAlias;
        followings = following;
        this.options = options;
    }

    public String[] getOptions() {
        return options;
    }

    public Message getFollowing(int choiceIndex){
        return followings[choiceIndex];
    }

    public String getContent() {
        return content;
    }

    public Texture getAlias() {
        return alias;
    }
}
