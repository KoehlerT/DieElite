package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.game.interactables.Traber;
import com.quickmathstudios.dieelite.utillity.Action;

public class Classroom1 extends Room {
    public Classroom1() {
        super("klassenraumback.png");
        Interactable traber = new Traber(new Vector2(100,200));
        Interactable ranzen = new Ranzen(new Vector2(800, 200), new Action() {
            @Override
            public void act() {
                RoomChanger.getInstance().changeRoom(new Secretary());
            }
        });
        setInteractables(new Interactable[]{traber,ranzen});
    }
}