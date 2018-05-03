package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Bernweich;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

public class Classroom2 extends Room {


    public Classroom2() {
        super("klassenraumback.png");

        Interactable bernweich = new Bernweich(new Vector2(100,200));

        super.setInteractables(new Interactable[]{bernweich});
    }
}
