package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.interactables.Ranzen;

public class CorridorBase extends Room{
    public CorridorBase(){
        super("gangback.png");
        Interactable ranzen = new Ranzen(new Vector2(200,200));
        super.setInteractables(new Interactable[]{ranzen});
    }
}
