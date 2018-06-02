package com.quickmathstudios.dieelite.minigames.rowing.swimming;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;
import com.quickmathstudios.dieelite.utillity.hit.Hitable;

public abstract class SwimmingObject implements Disposable{

    private Vector2 location;
    private float speed;
    protected Texture texture;
    protected Animation<TextureRegion> animation;
    private HitBox hitbox = new HitBox(Vector2.Zero,Vector2.Zero);
    private boolean edible;

    public SwimmingObject(float speed, Vector2 location, boolean edible){
        this.speed = speed;
        this.location = location;
        this.edible = edible;
    }

    public void updateLocation(float deltaTime, float speedMultiplier){
        location.sub(deltaTime*speed*speedMultiplier,0);
    }

    public HitBox getHitbox() {
        hitbox.getUL().set(location);
        hitbox.getOR().set(texture.getWidth(),texture.getHeight()).add(location);
        return hitbox;
    }

    public TextureRegion getTextureRegion(float stateTime){
        return animation.getKeyFrame(stateTime,true);
    }

    public boolean isEdible() {
        return edible;
    }

    public Vector2 getLocation(){
        return location;
    }
    @Override
    public void dispose() {
        texture.dispose();
    }
}
