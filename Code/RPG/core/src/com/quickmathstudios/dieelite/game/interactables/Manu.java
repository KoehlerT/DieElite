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
    Texture alias;

    Message dialogue;

    public Manu(Vector2 position) {
        InteractionRadius = new HitBox(position,new Vector2(50,100).add(position));
        ClickRadius = new HitBox(new Vector2(-50,-50).add(position),new Vector2(130,230).add(position));
        texture = new Texture("entities/manu.png");
        TextureRegion[] trs =  TextureRegion.split(texture,texture.getWidth()/2,texture.getHeight())[0];
        animation = new Animation<TextureRegion>(0.25f,trs);
        this.position = position;
        alias = new Texture("entities/manuAlias.png");
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
        dialogue = new SimpleMessage("Du hast gerade einen Eistee weggeworfen",alias,
                new SimpleMessage("Vom Pfand könnte ein Kind in Afrika 10 JAHRE überleben!!!!!",alias,
                new ActionMessage("Bacon though", alias, null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                })));
    }

    @Override
    public void dispose() {
        super.dispose();
        alias.dispose();
    }
}
