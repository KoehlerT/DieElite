package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.interactables.Arrow;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.utillity.Action;

import java.util.LinkedList;
import java.util.List;

public class CorridorBase extends Room {
    public CorridorBase(Vector2 playerSpawn, byte doorsactive) {
        super("rooms/gang.png");
        Player.getInstance().setPosition(playerSpawn);
        initDoors(doorsactive);

    }

    private void initDoors(byte doorsactive){
        List<Interactable> doors = new LinkedList<Interactable>();
        if ((doorsactive | (byte) 0b1111_1110) == (byte)0b11111111) {
            Interactable pfeilzuGar = new Arrow(new Vector2(400, 50), new Action() {
                @Override
                public void act() {
                    StoryEngine.getInstance().updateStory();

                }
            },"L");
            doors.add(pfeilzuGar);
        } else if ((doorsactive | (byte) 0b1111_1101) == (byte)0b11111111) {
            Interactable pfeilzuSec = new Arrow(new Vector2(100, 150), new Action() {
                @Override
                public void act() {
                    StoryEngine.getInstance().updateStory();

                }
            },"L");
            doors.add(pfeilzuSec);
        } else if ((doorsactive | (byte) 0b1111_1011) == (byte)0b11111111) {
            Interactable pfeilzuClass = new Ranzen(new Vector2(400, 350), new Action() {
                @Override
                public void act() {
                    StoryEngine.getInstance().updateStory();

                }
            });
            doors.add(pfeilzuClass);

        } else if ((doorsactive | (byte) 0b1111_0111) == (byte)0b11111111) {
            Interactable pfeilzuClassiwo = new Ranzen(new Vector2(700, 150), new Action() {
                @Override
                public void act() {
                    StoryEngine.getInstance().updateStory();

                }
            });
            doors.add(pfeilzuClassiwo);
        }
        Interactable[] doorArray = new Interactable[doors.size()];
        doors.toArray(doorArray);
        super.setInteractables(doorArray);
    }
}