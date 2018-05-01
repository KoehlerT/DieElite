package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.main.SoundManager;
import com.quickmathstudios.dieelite.utillity.hit.Button;

public class MenuRenderer {

    public MainMenu menu; //Referenz zum Modell

    public MenuRenderer(MainMenu m){
        menu = m;
        //Die Hintergrundmusik wird abgespielt
        SoundManager.getInstance().playBackground();
    }

    public void Render(SpriteBatch batch){
        //Anzeigen des Hintergrundes
        batch.draw(menu.getBackground(),0,0);

        //Anzeigen der Buttons
        for(Button b: menu.getButtons()){
            batch.draw(b.getTexture(),b.getPosition().x,b.getPosition().y);
        }
    }
}
