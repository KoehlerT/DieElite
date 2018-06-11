package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

import javax.xml.soap.Text;

public class Dog extends Interactable {
    Animation<TextureRegion> animation;
    private float animationTime = 0f;

    private float speed;
    private Vector2 finish;

    public Dog(Vector2 start, Vector2 finish, float speed){

        texture = new Texture("entities/dog.png");
        TextureRegion[] frames = new TextureRegion[4];
        TextureRegion[][] regions = TextureRegion.split(texture,texture.getWidth()/2,texture.getHeight()/2);
        frames[0] = regions[0][0];
        frames[1] = regions[0][1];
        frames[2] = regions[1][0];
        frames[3] = regions[1][1];
        animation = new Animation<TextureRegion>(0.2f,frames);
        this.finish = finish;
        this.speed = speed;
        position = start;
    }

    Vector2 move = new Vector2(0,0);

    @Override
    public void updateAnimation(float delta) {
        animationTime += delta;

        //Berechne Bewegungsvektor -> Müsste in Control-Klasse stehen, Ausnahmen bestätigen die Regel
        move.set(finish);
        move.sub(position);
        move.setLength(1);
        move.scl(speed);
        move.scl(delta);

        position.add(move);
    }

    @Override
    public TextureRegion getTexture() {
        return animation.getKeyFrame(animationTime,true);
    }

    @Override
    public void interact() {
        StoryEngine.getInstance().updateStory();
    }

    @Override
    public boolean isClicked(Vector2 cursorPos) {

        return new HitBox(position,new Vector2(150,100).add(position)).intersects(cursorPos);
    }

    @Override
    public boolean inRadius(Vector2 obj) {
        return new HitBox(position,new Vector2(100,50).add(position)).intersects(obj);
    }
}
