package com.quickmathstudios.dieelite.game.dialogueEngine.dialogue;

import com.badlogic.gdx.graphics.Texture;

public class Message {

    private Message[] followings;
    private String[] options;
    private String alias;
    private String content;
    private int voiceId;

    public Message(String message, String aliasId, Message[] following, String[] options) {
        content = message;
        alias = aliasId;
        followings = following;
        this.options = options;
        this.voiceId = -1;
    }

    public Message(String message, String aliasId, int voiceId, Message[] following, String[] options) {
        content = message;
        alias = aliasId;
        followings = following;
        this.options = options;
        this.voiceId = voiceId;
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

    public String getAliasId() {
        return alias;
    }

    public int getVoiceId(){return voiceId;}
}
