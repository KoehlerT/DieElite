package com.quickmathstudios.dieelite.utillity.hit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.util.LinkedList;
import java.util.List;

public class Button extends HitBox {

    private Texture normal;
    private Texture hover;
    private Vector2 position;
    private Action action;

    private boolean hovers = false;

    public Button(Texture norm, Texture hov, Vector2 pos, Action act){
        super(pos,new Vector2(pos.x+norm.getWidth(),pos.y+norm.getHeight()));
        normal = norm;
        hover = hov;
        position = pos;
        action = act;
    }

    @Override
    public boolean intersects(Vector2 curs) {
        return super.intersects(curs);
    }

    public void hover(Vector2 mousePos){
        if (super.intersects(mousePos) && !hovers){
            hovers = true;
        }else if (!super.intersects(mousePos) && hovers){
            hovers = false;
        }
    }

    public Vector2 getPosition(){
        return position;
    }

    public Texture getTexture(){
        if (hovers){
            return hover;
        }else{
            return normal;
        }

    }

    public void click(){
        action.act();
    }

    public void dispose(){
        normal.dispose();
        hover.dispose();
    }

}
