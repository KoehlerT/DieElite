package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Arrow extends Interactable{

    Action interact;

    public Arrow(Vector2 position, Action interact,String direction){
        super(new Texture("misc/arrow"+direction+".png"),
                position,
                interact);
        this.interact = interact;
    }


}
