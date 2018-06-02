package com.quickmathstudios.dieelite.minigames.rowing.swimming;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import javax.xml.stream.FactoryConfigurationError;

public class Chainsaw extends SwimmingObject {
    public Chainsaw(int height) {
        super(150f, new Vector2(1250,height), false);

        texture = new Texture("minigames/row/fishes/chainsaw.png");
        TextureRegion[][] regions = TextureRegion.split(texture,texture.getWidth(),texture.getHeight()/2);
        TextureRegion[] frames = new TextureRegion[]{regions[0][0], regions[1][0]};

        animation = new Animation<TextureRegion>(0.2f,frames);
    }
}
