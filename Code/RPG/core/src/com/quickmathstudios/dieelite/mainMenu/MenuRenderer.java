package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.utillity.hit.Button;

public class MenuRenderer {

    public MainMenu menu;

    public MenuRenderer(MainMenu m){
        menu = m;
    }

    public void Render(SpriteBatch batch){
        batch.draw(menu.getBackground(),0,0);
        for(Button b: menu.getButtons()){
            batch.draw(b.getTexture(),b.getPosition().x,b.getPosition().y);
        }
    }
}
