package com.quickmathstudios.dieelite.mainMenu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.credits.CreditsState;
import com.quickmathstudios.dieelite.loadingScreen.loadingState;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.Button;

/**Hält die Daten über das Menüobjekt
 * **/
public class MainMenu implements Disposable{

    private Texture background; //Hintegrund des Menüs

    private Button[] btns = new Button[2]; //Menübuttons

    public MainMenu(){
        background = new Texture("menu/background.png");

        //Buttons werden instanziiert
        //Bestehen aus Normaler Textur, Hover Textur, Position, Click-Aktion
        //Play Button
        btns[0] = new Button(new Texture("menu/play_norm.png"),
                new Texture("menu/play_hover.png"),
                new Vector2(277, 386), new Action() {
            @Override
            public void act() {
                StateEngine.getInstance().SwitchState(new loadingState());
            }
        });
        //Credits Button
        btns[1] = new Button(new Texture("menu/Credits_norm.png"),
                new Texture("menu/Credits_hover.png"),
                new Vector2(277, 276), new Action() {
            @Override
            public void act() {
                StateEngine.getInstance().SwitchState(new CreditsState());
            }
        });

    }

    //Getter
    public Texture getBackground(){
        return background;
    }

    public Button[] getButtons(){
        return btns;
    }



    @Override
    public void dispose() {
        //Arbeitsspeicher freigeben
        for (Button b : btns){
            b.dispose();
        }
        background.dispose();
    }
}
