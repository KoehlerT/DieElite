package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Arrow extends Interactable{

    Texture t;
    Action interact;

    public Arrow(Vector2 position, Action interact,String direction){
        super(new HitBox(position,new Vector2(position.x+100,position.y+100)),
                new HitBox(new Vector2(position.x-20,position.y-20),new Vector2(position.x+100,position.y+100)),
                interact);
        t = new Texture("misc/arrow"+direction+".png");
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
