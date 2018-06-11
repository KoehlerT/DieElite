package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.rooms.Classroom1;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Ranzen extends Interactable {

    TextureRegion tr;
    Action interact;

    public Ranzen(Vector2 position, Action interact){
        super(new Texture("ranzen.png"),
                position,
                interact);

        this.interact = interact;
    }

}
