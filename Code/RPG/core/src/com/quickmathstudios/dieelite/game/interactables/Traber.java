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
    Message dialog;

    public Traber(Vector2 position, int dialogOption){
        super(new Texture("traber.png"),
                position,null);
        alias = new Texture("traberAlias.png");
        getDialog(dialogOption);
    }

    private void getDialog(int index){
        if (index == 0){
            Message root = new Message("Grüß Gott, würdest du bitte Kreide holen?",alias,
                    new Message[] {new SimpleMessage("So wirst du das Abitur nie schaffen!",alias,null),
                            new ActionMessage("Diese Arbeitshaltung, sehr löblich!", alias, null, new Action() {
                        @Override
                        public void act() {
                            StoryEngine.getInstance().updateStory();
                        }
                    })},
                    new String[]{"Nein","Ja"});
            dialog = root;
        }else{
            //Du Bist zurück gekommen
            Message root = new SimpleMessage("Du bist nicht umsonst auf dem Gymnasium",alias,
                    new SimpleMessage("Deine Motivation und Arbeitsmoral bringen dich auf die Hauptschule",alias,
                    new SimpleMessage("Wenigstens Kreide holen kannst du!",alias,
                    new ActionMessage("Dankeschön!",alias,null,new Action(){
                @Override
                public void act(){
                    StoryEngine.getInstance().updateStory();
                }
            }))));
            dialog = root;
        }
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(dialog);
    }


    @Override
    public void dispose(){
        super.dispose();
        alias.dispose();
    }
}
