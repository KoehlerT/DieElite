package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

public abstract class Room {

    private Interactable[] interactables;
    private Texture background;

    public Room(String internalPathBackground){
        background = new Texture(internalPathBackground);
    }

    protected void setInteractables(Interactable[] ints){
        interactables = ints;
    }

    public Texture getBackground(){
        return  background;
    }
    public Interactable[] getInteractables(){
        return  interactables;
    }
    public void dispose(){
        background.dispose();
        for (Interactable i : interactables)
            i.dispose();
    }
}
