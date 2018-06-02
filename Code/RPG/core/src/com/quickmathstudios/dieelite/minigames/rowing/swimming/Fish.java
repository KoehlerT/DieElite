package com.quickmathstudios.dieelite.minigames.rowing.swimming;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Fish extends SwimmingObject {
    public Fish(float height) {
        super(150f, new Vector2(1250,height), true);

        texture = new Texture("minigames/row/fishes/fish.png");
        TextureRegion[] frames = TextureRegion.split(texture,texture.getWidth()/2,texture.getHeight())[0];
        animation = new Animation<TextureRegion>(0.2f,frames);
    }
}
