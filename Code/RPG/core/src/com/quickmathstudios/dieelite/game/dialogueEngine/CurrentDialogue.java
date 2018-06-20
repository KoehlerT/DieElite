package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.graphics.Color;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;

/**Informationen über Dialog
 * Messages verweisen auf sich selbst und generieren einen Entscheidungs-Verweißbaum
 * Die Nachricht die gerade angezeigt wird, wird hier gespeichert
 * **/
public class CurrentDialogue {
    //Singleton
    private static CurrentDialogue ourInstance = new CurrentDialogue();

    public static CurrentDialogue getInstance() {
        return ourInstance;
    }

    private Message current;
    private int hovering;

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
        if (current == null)
            return;
        if (current.getOptions().length > choiceIndex && choiceIndex >= 0){ //Check, ist Index Legal?
            current = current.getFollowing(choiceIndex);

        }
    }

    public int hovering(){
        return hovering;
    }

    public void setHovering(int hov){
        hovering = hov;
    }

    public boolean currentlyTalking(){
        return current != null;
    }
}
