package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.input.MouseHover;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;
import com.quickmathstudios.dieelite.utillity.hit.Button;

/**Übernimmt die Modifikationen am Menü-Modell
 * Übernimmt das Kontrollieren der Maus
 * **/
public class MenuController implements Observer, Disposable {

    private MainMenu menu;

    public MenuController(MainMenu m){
        //Beobachtet Mausbewegungen und Mausclicks
        MouseClick.getInstance().addObserver(this);
        MouseHover.getInstance().addObserver(this);
        menu = m;
    }

    @Override
    public void dispose() {
        //Abmelden von den Beobachtbaren
        MouseClick.getInstance().deleteObserver(this);
        MouseHover.getInstance().deleteObserver(this);
        menu.dispose();
    }

    @Override
    public void Update(Observable observable, Object sender) {
        //Ein Observable meldet eine Veränderung!!!!!!!!!!
        if (observable instanceof MouseClick) {
            MouseClick mouseClick = (MouseClick) observable;
            //Bei Mausclick
            Button[] btns = menu.getButtons();

            //Kontolliert, welcher Button geklickt wurde
            for (Button b: btns){
                if (b.intersects(mouseClick.getPosition())){
                    b.click(); //Clickaktion wird ausgeführt
                }
            }
        }else if (observable instanceof MouseHover){
            MouseHover mouseHover = (MouseHover)observable;
            //Bei Mausbewegung

            Button[] btns = menu.getButtons();
            //Kontrolleirt, welcher Button von der Maus berührt wird
            for (Button b: btns){
                b.hover(mouseHover.getPosition()); //Hoverlogik der Buttons
            }
        }
    }
}
