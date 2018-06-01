package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.Texture;

import javax.xml.soap.Text;

public class MovieCutscene extends Cutscene {

    private float frameDuration;
    private float displayTime;


    public MovieCutscene(String name, float duration) {
        super(name);
        frameDuration = duration;
    }


    @Override
    public void updateLogic(float time){
        displayTime += time;

        int index = (int)(displayTime/frameDuration);
        if (index >= super.textures.length)
            index = super.textures.length -1;

        currentTexture = index;

    }



    @Override
    public boolean nextStep() {
        return false;//Bei einem Click wird die Cutscene übersprungen
    }
}
