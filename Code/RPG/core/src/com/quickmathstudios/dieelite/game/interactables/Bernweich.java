package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;
import com.quickmathstudios.dieelite.utillity.hit.Hitable;

public class Bernweich extends Interactable{

    Texture alias = new Texture("bernweichAlias.png");

    Message dialog;

    public Bernweich(Vector2 position) {
        super(new Texture("bernweich.png"),
                new HitBox(position,new Vector2(position.x+75,position.y+150)),
                new HitBox(position,new Vector2(position.x+50,position.y+100)), null);
        this.position = position;

        constructMessage(constructRiddle());
    }

    private Message constructRiddle(){
        Message fail = new SimpleMessage("Setzen SEX",alias,null);
        Message question = new Message("Was ist die Formel zum Berechnen des Flächeninhalts eines Kreises?",alias,
                new Message[]{
                    new SimpleMessage("Du Quadratschädel",alias,fail),
                        new SimpleMessage("Die Kreiskugel",alias,fail),
                        new SimpleMessage("Aha",alias,
                                new ActionMessage("Möchtest du zu \"Jugend Forscht?\"", alias, null, new Action() {
                                    @Override
                                    public void act() {
                                        StoryEngine.getInstance().updateStory();
                                        System.out.println("Geredet mit BW");
                                    }
                                }))
                }, new String[]{"r^2","2rpi^2","pi*r^2"});

        return question;
    }

    private void constructMessage(Message riddle){
        dialog = new SimpleMessage("Oh, Ich habe euch heute in meiner Vertretungsstunde",alias,
                new SimpleMessage("Ich habe ein tolles Mathespiel für euch vorbereitet.",alias,
                        new SimpleMessage("Ich stelle euch jetzt 10 Fragen, wer am meisten richtig hat, hat gewonnen",alias,
                                riddle)));
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(dialog);
    }


    @Override
    public void dispose() {
        super.dispose();
        alias.dispose();
    }
}
