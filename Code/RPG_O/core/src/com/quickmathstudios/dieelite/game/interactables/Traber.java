package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.rooms.CorridorBase;
import com.quickmathstudios.dieelite.game.rooms.Secretary;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Traber extends Interactable{

    Texture t;
    Texture alias;
    public Traber(Vector2 position){
        super(new HitBox(position,new Vector2(position.x+100,position.y+200)),
                new HitBox(position,new Vector2(position.x+100,position.y+200)),null);
        t = new Texture("traber.png");
        alias = new Texture("traberAlias.png");
        this.position = position;
    }

    @Override
    public void interact() {
        Message root = new Message("Grüß Gott, würdest du bitte Kreide holen?",alias,
                new Message[] {new SimpleMessage("So wirst du das Abitur nie schaffen!",alias,null),new ActionMessage("Diese Arbeitshaltung, sehr löblich!", alias, null, new Action() {
                    @Override
                    public void act() {
                        StoryEngine.getInstance().updateStory();
                    }
                })},
                new String[]{"Nein","Ja"});
        CurrentDialogue.getInstance().addDialogue(root);
    }

    @Override
    public Texture getTexture() {
        return t;
    }

    @Override
    public void dispose(){
        t.dispose();
        alias.dispose();
    }
}
