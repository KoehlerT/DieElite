package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.main.SoundManager;
import com.quickmathstudios.dieelite.utillity.State;

/**Die Gamestate Klasse des Hauptmenüs.
 * Es wird das Modell instanziiert
 * Dem Controller- und View-Objekt werden jetzt die Kontrolle überlassen
 * **/
public class MenuScreen implements State {

    MainMenu menu; //Das Datenhaltende Objekt des Hauptmenüs
    MenuController contr; //Der Controller des Hauptmenüs
    MenuRenderer rend; //Der Renderer des Hauptmenüs

    @Override
    public void Show() {
        //Instanziieren der Klassen
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
