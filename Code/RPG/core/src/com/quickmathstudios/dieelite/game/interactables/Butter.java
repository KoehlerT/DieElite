package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Butter extends Interactable {
    private Texture alias;

    public Butter(Vector2 position){
        super(new Texture("entities/butter.png"),
                position,
                null);
    }

    private Message getDialogue(){
        Message root = new ActionMessage("Rudern ist gut für den ganzen Körper. Es gibt keine Sportart, die so viel \nfür alle Teile des Körpers macht, wie es rudern tut. Bauch, Rücken, Beine und Arme\n alles wird zu Kruppstahl durch Ruderübungen. Also zeig mir was deine Fähigkeiten sind \nund wenn du eine ausreichende Punktzahl erreichst, gibt es eine Belohnung. ", "butter", null, new Action() {
            @Override
            public void act() {
                StoryEngine.getInstance().updateStory(1);
            }
        });

        if (StoryEngine.getInstance().getStep() > 1){
            //Ruderspiel fertig!
            if (StoryEngine.getInstance().getBranch() == 0){
                root = new ActionMessage("Du hast es gar nicht richtig probiert. Als ich deinen Körper gesehen habe,\n habe ich perfekte Eignung für Rudern festgestellt. \nDu bist die größte Enttäuschung die ich seit Julian und Tim je hatte.\n Bitte komm Freitag in mein Büro um diesen Fehler auszubügeln.", "butter", null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                });
            }else{
                root = new ActionMessage("So ein gutes Ergebnis, dass hatte das letzte mal \nmein Schüler Klaus. Der ist zum bairischen Landesentscheid gefahren. \nBitte komm Freitag in mein Büro. ", "butter", null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                });
            }
        }



        return root;
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(getDialogue());
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
