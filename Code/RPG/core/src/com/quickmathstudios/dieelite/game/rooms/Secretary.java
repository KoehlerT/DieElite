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


        Vector2 chalkPosition = new Vector2(800,75);

        Interactable chalk = new Interactable(new Texture("objects/chalk.png"),chalkPosition,
                new Action(){
                    @Override
                    public void act(){
                        StoryEngine.getInstance().updateStory();
                    }
                }){

        };

        setInteractables(new Interactable[]{chalk});
    }
}
