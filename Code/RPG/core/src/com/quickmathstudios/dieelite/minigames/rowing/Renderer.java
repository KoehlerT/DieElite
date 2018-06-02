package com.quickmathstudios.dieelite.minigames.rowing;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.awt.*;

public class Renderer {

    Minigame toRender;

    BitmapFont font;

    Renderer(Minigame minigame){
        toRender = minigame;
        font = new BitmapFont();
        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
    }

    public void Render(SpriteBatch b){
        //Backgorund
        b.draw(toRender.getBackground(),0,0);

        //Objects
        FrameLocation[] frameLocations = toRender.getFrameLocations();

        for (FrameLocation fl : frameLocations){
            b.draw(fl.frame,fl.location.x,fl.location.y);
        }

        //Score
        font.draw(b,""+toRender.getScore(),50,700);

    }
}
