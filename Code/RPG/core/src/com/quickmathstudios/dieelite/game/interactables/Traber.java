package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

    Animation<TextureRegion> animation;
    private float animationTime = 0f;
    Texture t;

    String alias = "traber";
    Message dialog;

    public Traber(Vector2 position, int dialogOption){
        super(new Texture("entities/traber.png"),
                position,null);
        getDialog(dialogOption);

        t = new Texture("entities/traber.png");
        TextureRegion[] trs =  TextureRegion.split(t,t.getWidth()/3,t.getHeight())[0];
        animation = new Animation<TextureRegion>(0.25f,trs);

        InteractionRadius = new HitBox(new Vector2(-25,-25).add(position),new Vector2(120,230).add(position));
        ClickRadius = new HitBox(new Vector2(-50,-50).add(position),new Vector2(130,230).add(position));

    }

    private void getDialog(int index){
        if (index == 0){
            Message root = new Message("Hallo Kevin, würdest du bitte ins Sekretäriat eilen\n" +
                    "und mir eine Packung Kreide holen?",alias,
                    new Message[] {new SimpleMessage("Mit Verlaub junger Mann, so kann das nicht weitergehen. \n" +
                            "Du bist die Elite des bayrisches Bildungswesens und so wirst du das Abitur vielleicht \n" +
                            "schaffen, aber viel weiter bringst du es dann auch nicht!",alias,null),
                            new ActionMessage("Diese Arbeitshaltung ist sehr löblich.\n So etwas begegnet einem heutzutage selten.", alias, null, new Action() {
                        @Override
                        public void act() {
                            StoryEngine.getInstance().updateStory();
                        }
                    })},
                    new String[]{"Nein","Ja"});
            dialog = root;
        }else{
            //Du Bist zurück gekommen
            Message root = new ActionMessage("Vielen Dank Kevin! Möchtest du vielleicht in den\n" +
                    " Mathepluskurs, oder mit mir alleine" +
                    "durch die Wildnis laufen und einen Geocache suchen?\n" +
                    " Nein? dann tust du mir leid...",alias,null,new Action(){
                @Override
                public void act(){
                    StoryEngine.getInstance().updateStory();
                }
            });
            dialog = root;
        }
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(dialog);
    }

    @Override
    public void updateAnimation(float delta) {
        animationTime += delta;
    }

    @Override
    public TextureRegion getTexture() {
        return animation.getKeyFrame(animationTime,true);
    }


    @Override
    public void dispose(){
        t.dispose();
        super.dispose();
    }
}
