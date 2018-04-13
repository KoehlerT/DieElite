package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Interactable {

    protected int InteractionRadius;
    protected int ClickRadius;
    protected Vector2 position;

    public Interactable(int ir, int cr){
        InteractionRadius = ir;
        ClickRadius = cr;
    }

    public abstract void interact();

    public boolean inRadius(Vector2 obj){
        return (obj.dst(position) < InteractionRadius);
    }

    public boolean isClicked(Vector2 cursorPos){
        return (cursorPos.dst(position) < ClickRadius);
    }

    public Vector2 getPosition() {
        return position;
    }

    public abstract Texture getTexture();
    public abstract void dispose();
}
