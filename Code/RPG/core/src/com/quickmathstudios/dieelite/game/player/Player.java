package com.quickmathstudios.dieelite.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

/**Spielerobjekt
 * Hält informationen über den Spieler
 * **/
public class Player extends Sprite {

    //region Singleton
    private static Player instance;
    public static Player getInstance(){return instance;}
    //endregion

    private Interactable target;
    private Vector2 aim;
    private float speed = 400; //Pixel/sec Eig. 200
    Texture texture = new Texture("entities/kevin.png");
    Animation<TextureRegion> animation;

    public Player(){
        super();
        instance = this;

        TextureRegion[] trs = TextureRegion.split(texture,texture.getWidth()/4,texture.getHeight())[0];
        animation = new Animation<TextureRegion>(1/8f, trs);
    }

    //Setter
    public void setPosition(Vector2 position){setX(position.x);setY(position.y);}
    public void setAim(Vector2 aim){this.aim = aim;}
    public void setTarget(Interactable target){this.target = target;}

    //Getter
    public float getSpeed(){return speed;}

    public Vector2 getAim() {
        if (target != null)
            return target.getPosition();
        else
            return aim;
    }
    public Vector2 getPosition(){return new Vector2(getX(),getY());}
    public boolean hasTarget(){return target != null;}

    public Interactable getTarget() {
        return target;
    }

    public TextureRegion getRegion(float animationTime){
        return animation.getKeyFrame(animationTime,true);
    }

    public void dispose(){

    }
}
