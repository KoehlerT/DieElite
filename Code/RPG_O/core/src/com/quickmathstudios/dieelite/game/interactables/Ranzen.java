package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.rooms.Classroom1;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Ranzen extends Interactable {

    Texture t = new Texture("ranzen.png");
    Action interact;

    public Ranzen(Vector2 position, Action interact){
        super(new HitBox(position,new Vector2(position.x+100,position.y+100)),
                new HitBox(position,new Vector2(position.x+100,position.y+100)),
                interact);

        this.position = position;
        this.interact = interact;
    }

    @Override
    public Texture getTexture(){
        return t;
    }

    @Override
    public void dispose(){
        t.dispose();
    }
}
