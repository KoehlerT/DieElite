package com.quickmathstudios.dieelite.game.rooms;

import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Traber;

public class Classroom1 extends Room {
    public Classroom1() {
        super("klassenraumback.png");
        Interactable traber = new Traber();
        setInteractables(new Interactable[]{traber});
    }
}