package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Dog;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.player.Player;

public class Story6 extends Room {

    public Story6() {
        super("rooms/way.png");

        Dog dog =new Dog(new Vector2(1200,200),new Vector2(0,100),150f);
        Player.getInstance().setPosition(new Vector2(900,250));
        super.setInteractables(new Interactable[]{dog});
    }
}
