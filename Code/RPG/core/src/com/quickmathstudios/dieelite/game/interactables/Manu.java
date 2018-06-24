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
import com.badlogic.gdx.graphics.g2d.Animation;

public class Manu extends Interactable {
    Animation<TextureRegion> animation;
    private boolean visible = false;
    private float animationTime = 0f;

    Message dialogue;

    public Manu(Vector2 position) {
        InteractionRadius = new HitBox(new Vector2(-25,-25).add(position),new Vector2(120,230).add(position));
        ClickRadius = new HitBox(new Vector2(-50,-50).add(position),new Vector2(130,230).add(position));
        texture = new Texture("entities/manu.png");
        TextureRegion[] trs =  TextureRegion.split(texture,texture.getWidth()/1,texture.getHeight())[0];
        animation = new Animation<TextureRegion>(0.25f,trs);
        this.position = position;
        constructDialogue();
    }

    @Override
    public void updateAnimation(float delta) {
        animationTime += delta;
    }

    @Override
    public void interact() {
        if (visible){
            CurrentDialogue.getInstance().addDialogue(dialogue);
        }
    }

    @Override
    public TextureRegion getTexture() {
        if (visible){
            return animation.getKeyFrame(animationTime,true);
        }
        return null;
    }

    public void setVisible(){
        visible = true;
    }

    private void constructDialogue(){
        dialogue = new SimpleMessage("WAS FÄLLT DIR EIN? Ein Kind in Afrika würde davon einen Tag lang \nleben können. Ich hab da so ne Applikation in diesem Playstore gefunden. \nDa könntest du die 40 Cent spenden und einem Kind einen Tag retten.\n Stattdessen schmeißt du es weg, du abgehobener Schnösel.",
                "manu",7,
                new Message("Aber so wie ich dich kenne ignorierst du es eh einfach. Weißt du, \nmanchmal erzähle ich Leuten was schlimmes mit Schweinen beim Schlachter passiert,\n aber die ignorieren das einfach….","manu",
                new Message[] {new ActionMessage("SOFORT WEG HIER!", "manu", null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                })},new String[] {"bacon, though"}));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
