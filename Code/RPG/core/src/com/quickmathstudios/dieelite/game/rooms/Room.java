package com.quickmathstudios.dieelite.game.rooms;

import com.badlogic.gdx.graphics.Texture;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

/**Raumtemplate
 * Hält informationen über Interaktionfähige Objekte
 * **/
public abstract class Room {

    private Interactable[] interactables; //Interagierbare Objekte
    private Texture background; //Hintergrundgrafik

    public Room(String internalPathBackground){
        background = new Texture(internalPathBackground);
    }

    //Setter
    protected void setInteractables(Interactable[] ints){
        interactables = ints;
    }

    //Getter
    public Texture getBackground(){
        return  background;
    }
    public Interactable[] getInteractables(){
        return  interactables;
    }

    //Arbeitsspeicher freigeben
    public void dispose(){
        background.dispose();
        for (Interactable i : interactables)
            i.dispose();
    }
}
