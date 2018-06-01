package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.Hitable;

import javax.xml.bind.ValidationException;

/**Ineraktionsfähiges Objekt
 * **/
public abstract class Interactable {

    protected Hitable InteractionRadius; //Minimaler Radius für Interaktion
    protected Hitable ClickRadius;  //Hitbox für Mauscursor
    private Action interaction; //Funktion der Interaktion
    protected Vector2 position; //Position (UL) der Grafik und Zentrum der Radien

    protected Texture texture;
    protected TextureRegion tr;

    public Interactable(Texture t,Hitable interactionBox, Hitable clickBox, Action action){
        InteractionRadius = interactionBox;
        ClickRadius = clickBox;
        interaction = action;
        tr = TextureRegion.split(t,t.getWidth(),t.getHeight())[0][0];
        setPosition();
    }

    public Interactable(){}
    protected void setPosition(){
        this.position = null;
    }

    //INteraktionsmethode muss überschrieben werden
    public void interact(){
        interaction.act();
    };

    public void updateAnimation(float delta){}

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

    public TextureRegion getTexture(){
        return tr;
    }
    public void dispose(){
        if (texture != null){
            texture.dispose();
        }

    }
}
