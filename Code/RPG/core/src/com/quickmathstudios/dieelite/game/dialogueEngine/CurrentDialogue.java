package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;

public class CurrentDialogue {
    private static CurrentDialogue ourInstance = new CurrentDialogue();

    public static CurrentDialogue getInstance() {
        return ourInstance;
    }

    private Message current;

    private CurrentDialogue(){
        current = null;
    }

    public void addDialogue(Message root){
        current = root;
    }

    public Message getCurrent() {
        return current;
    }

    public void next(int choiceIndex){
        if (current.getOptions().length > choiceIndex){
            current = current.getFollowing(choiceIndex);
        }
    }

    public boolean currentlyTalking(){
        return current != null;
    }
}
