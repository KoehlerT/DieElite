package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.utillity.Action;

public class CorridorBase extends Room{
    public CorridorBase(Vector2 playerSpawn){
        super("rooms/gang.png");
        Player.getInstance().setPosition(playerSpawn);
        Interactable ranzen = new Ranzen(new Vector2(200, 200), new Action() {
            @Override
            public void act() {
                RoomChanger.getInstance().changeRoom(new Classroom1());

            }
        });
        super.setInteractables(new Interactable[]{ranzen});
    }
}
