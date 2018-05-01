package com.quickmathstudios.dieelite.credits;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.GameState;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.input.MouseHover;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.mainMenu.MenuScreen;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;
import com.quickmathstudios.dieelite.utillity.State;
import com.quickmathstudios.dieelite.utillity.hit.Button;

/**Credits Screen
 * Model-View-Controller Schema wird verletzt
 * Klasse ist State, Model, View und Controller gleichzeitig
 *
 * **/
public class CreditsState implements State, Observer {

    private Texture background; //Hintergrundtextur
    private Button back; //Zurückbutton

    @Override
    public void Show() {
        background = new Texture("credits/background.png");

        //Zurückschaltfäche wird instanziiert
        back = new Button(new Texture("credits/backBtn.png"),
                new Texture("credits/backBtn_hover.png"),
                new Vector2(1000, 50),
                new Action() {
            @Override
            public void act() {
                StateEngine.getInstance().SwitchState(new MenuScreen());
            }
        });

        //Klasse beobachtet Mausklicks und -bewegungen
        MouseClick.getInstance().addObserver(this);
        MouseHover.getInstance().addObserver(this);
    }

    @Override
    public void Render(SpriteBatch batch) {
        //Hintergrund wird angezeigt
        batch.draw(background,0,0);
        //Zeigt den Button
        batch.draw(back.getTexture(),back.getPosition().x,back.getPosition().y);
    }

    @Override
    public void Update(float delta) { }

    @Override
    public void dispose() {
        //Arbeitsspeicher freigeben
        background.dispose();
        back.dispose();
        MouseHover.getInstance().deleteObserver(this);
        MouseClick.getInstance().deleteObserver(this);

    }

    @Override
    public void Update(Observable observable, Object sender) {
        //Obserbable meldet eine Veränderung
        if (observable instanceof MouseClick) {
            MouseClick mouseC = (MouseClick) observable;
            //bei Mausklicks
            if (back.intersects(mouseC.getPosition())){
                back.click();
            }
        }else if (observable instanceof MouseHover){
            //Bei Mausbewegungen
            MouseHover mouseHover = (MouseHover) observable;
            back.hover(mouseHover.getPosition());
        }
    }
}
