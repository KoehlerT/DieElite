package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Secretary extends Room {



    public Secretary() {
        super("rooms/sekreteriat.png");

        Interactable ranzen = new Ranzen(new Vector2(200, 200), new Action() {
            @Override
            public void act() {
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(100,100), (byte) 0b0000_0010));
            }
        });

        Vector2 chalkPosition = new Vector2(800,75);

        Interactable chalk = new Interactable(new HitBox(chalkPosition, new Vector2(chalkPosition.x+30,chalkPosition.y+60)),
                new HitBox(chalkPosition, new Vector2(chalkPosition.x+50,chalkPosition.y+80)),
                new Action(){
                    @Override
                    public void act(){
                        StoryEngine.getInstance().updateStory();
                    }
                }){

            private Texture texture = new Texture("objects/chalk.png");

            @Override
            public Vector2 getPosition() {
                return chalkPosition;
            }

            @Override
            public Texture getTexture() {
                return texture;
            }

            @Override
            public void dispose() {
                texture.dispose();
            }
        };

        setInteractables(new Interactable[]{chalk});
    }
}
