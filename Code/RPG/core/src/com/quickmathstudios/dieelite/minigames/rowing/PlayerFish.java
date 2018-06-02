package com.quickmathstudios.dieelite.minigames.rowing;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class PlayerFish implements Disposable {

    private Texture texture;
    private Animation<TextureRegion> animation;

    private Vector2 location;

    private float acceleration = -10;
    private float speed = 0;

    public PlayerFish(){
        texture = new Texture("minigames/row/fishes/player.png");
        TextureRegion[][] regions = TextureRegion.split(texture,texture.getWidth()/2,texture.getHeight()/2);
        TextureRegion[] frames = new TextureRegion[regions.length * regions[0].length];

        for (int x = 0; x < regions.length; x++){
            for (int y = 0; y < regions[x].length; y++){
                frames[x+y*regions[x].length] = regions[x][y];
            }
        }

        animation = new Animation<TextureRegion>(0.1f,frames);
        location = new Vector2(50,400);

    }

    public void move(float delataTime){
        speed = -200;
        if (location.y > 50)
            location.add(new Vector2(0,speed * delataTime));
    }

    public void addSpeed(float add){
        if (location.y<700)
            location.y += add;
        else
            location.y = 700;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public TextureRegion getTextureRegion(float stateTime){
        return animation.getKeyFrame(stateTime,true);
    }
    public Vector2 getLocation(){
        return location;
    }

    public HitBox getHitbox(){
        return new HitBox(location,new Vector2(100,75).add(location));
    }
}
