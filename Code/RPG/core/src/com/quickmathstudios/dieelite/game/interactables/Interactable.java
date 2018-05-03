package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.Hitable;

/**Ineraktionsfähiges Objekt
 * **/
public abstract class Interactable {

    protected Hitable InteractionRadius; //Minimaler Radius für Interaktion
    protected Hitable ClickRadius;  //Hitbox für Mauscursor
    private Action interaction; //Funktion der Interaktion
    protected Vector2 position; //Position (UL) der Grafik und Zentrum der Radien

    public Interactable(Hitable interactionBox, Hitable clickBox, Action action){
        InteractionRadius = interactionBox;
        ClickRadius = clickBox;
        interaction = action;
    }


    //INteraktionsmethode muss überschrieben werden
    public void interact(){
        interaction.act();
    };

    //Kontrolieren
    public boolean inRadius(Vector2 obj){
        return InteractionRadius.intersects(obj);
    }

    public boolean isClicked(Vector2 cursorPos){
        return ClickRadius.intersects(cursorPos);
    }

    //Getter
    public Vector2 getPosition() {
        return position;
    }

    public abstract Texture getTexture();
    public abstract void dispose();
}
