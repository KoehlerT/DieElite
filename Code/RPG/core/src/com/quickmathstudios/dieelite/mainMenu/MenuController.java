package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.input.MouseHover;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;
import com.quickmathstudios.dieelite.utillity.hit.Button;

public class MenuController implements Observer, Disposable {

    private MainMenu menu;

    public MenuController(MainMenu m){
        MouseClick.getInstance().addObserver(this);
        MouseHover.getInstance().addObserver(this);
        menu = m;
    }

    @Override
    public void dispose() {
        MouseClick.getInstance().deleteObserver(this);
        MouseHover.getInstance().deleteObserver(this);
        menu.dispose();
    }

    @Override
    public void Update(Observable observable, Object sender) {
        if (observable instanceof MouseClick) {
            MouseClick mouseClick = (MouseClick) observable;
            Button[] btns = menu.getButtons();

            for (Button b: btns){
                if (b.intersects(mouseClick.getPosition())){
                    b.click();
                }
            }
        }else if (observable instanceof MouseHover){
            MouseHover mouseHover = (MouseHover)observable;

            Button[] btns = menu.getButtons();
            for (Button b: btns){
                b.hover(mouseHover.getPosition());
            }
        }
    }
}
