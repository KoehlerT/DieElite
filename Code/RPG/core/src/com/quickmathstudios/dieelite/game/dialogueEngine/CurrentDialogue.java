package com.quickmathstudios.dieelite.game.dialogueEngine;

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
        if (current.getOptions().length > choiceIndex){ //Check, ist Index Legal?
            current = current.getFollowing(choiceIndex);

        }
    }

    public boolean currentlyTalking(){
        return current != null;
    }
}
