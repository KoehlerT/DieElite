package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.rooms.Classroom1;

public class Ranzen extends Interactable {

    Texture t;

    public Ranzen(Vector2 position){
        super(100,50);
        t = new Texture("ranzen.png");
        this.position = position;
    }

    @Override
    public Texture getTexture(){
        return t;
    }

    @Override
    public void interact(){
        System.out.println("INTERACTION");
        RoomChanger.getInstance().changeRoom(new Classroom1());
    }
    @Override
    public void dispose(){
        t.dispose();
    }
}
