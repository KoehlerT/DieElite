package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.utillity.State;

public class MenuScreen implements State {

    MainMenu menu;
    MenuController contr;
    MenuRenderer rend;

    @Override
    public void Show() {
        menu = new MainMenu();
        contr = new MenuController(menu);
        rend = new MenuRenderer(menu);
    }

    @Override
    public void Render(SpriteBatch batch) {
        rend.Render(batch);
    }

    @Override
    public void Update(float delta) {
    }

    @Override
    public void dispose() {
        contr.dispose();
        menu.dispose();

    }

}
