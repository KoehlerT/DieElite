package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.ButterQuestion;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

public class ButterOffice extends Room {
    public ButterOffice() {
        super("rooms/butteroffice.png");

        setInteractables(new Interactable[]{new ButterQuestion(new Vector2(500,200))});

    }
}
