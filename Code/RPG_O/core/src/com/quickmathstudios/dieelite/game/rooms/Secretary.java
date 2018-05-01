package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.utillity.Action;

public class Secretary extends Room {



    public Secretary() {
        super("rooms/sekreteriat.png");

        Interactable ranzen = new Ranzen(new Vector2(200, 200), new Action() {
            @Override
            public void act() {
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(100,100), (byte) 0b0000_0010));
            }
        });
        setInteractables(new Interactable[]{ranzen});
    }
}
