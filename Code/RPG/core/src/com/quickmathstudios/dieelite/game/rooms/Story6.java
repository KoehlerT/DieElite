package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Dog;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

public class Story6 extends Room {

    public Story6() {
        super("rooms/outside.png");

        Dog dog =new Dog(new Vector2(1200,100),new Vector2(0,400),200f);
        super.setInteractables(new Interactable[]{dog});
    }
}
