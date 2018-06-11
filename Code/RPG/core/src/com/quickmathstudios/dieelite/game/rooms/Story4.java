package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Manu;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

import java.util.Random;

public class Story4 extends Room {

    Manu manu;

    public Story4() {
        super("rooms/outside.png");

        Random r = new Random();

        Interactable[] trash = new Interactable[2+(r.nextInt(5)+2)];

        manu = new Manu(new Vector2(900,200));
        trash[0] = manu;

        Vector2 iceTeapos = new Vector2(r.nextInt(100)+100,r.nextInt(300)+50);
        trash[1] = new Interactable(new Texture("objects/icetea.png"),
                iceTeapos,
                new Action() {
                    @Override
                    public void act() {
                        System.out.println("MANU");
                        ActivateManu();
                    }
                }){

        };

        for (int i = 2; i < trash.length; i++){
            Vector2 trashPos = new Vector2(r.nextInt(650)+200,r.nextInt(300)+50);

            trash[i] = new Interactable(new Texture("objects/trash.png"),
                    trashPos,null) {
                @Override
                public void interact() {
                    texture = null;
                    tr = null;
                }
            };
        }

        setInteractables(trash);
    }

    public void ActivateManu(){
        manu.setVisible();
    }
}
