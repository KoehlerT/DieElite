package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Butter;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

public class Boathouse extends Room {
    public Boathouse() {
        super("rooms/boathouse.png");

        setInteractables(new Interactable[]{new Butter(new Vector2(100,300))});
    }
}
