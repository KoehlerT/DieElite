package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;
import com.quickmathstudios.dieelite.game.interactables.Traber;
import com.quickmathstudios.dieelite.utillity.Action;

public class Classroom1 extends Room {
    public Classroom1() {
        super("klassenraumback.png");
        int dstep = 1;
        if (StoryEngine.getInstance().getStep() <= 2)
            dstep = 0;
        Interactable traber = new Traber(new Vector2(100,200),dstep);
        setInteractables(new Interactable[]{traber});
    }
}