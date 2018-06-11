package com.quickmathstudios.dieelite.loadingScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.quickmathstudios.dieelite.game.GameState;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.utillity.State;

/**(Fake) loading Screen
 * Model-View-Contoller wird verletzt.
 * Objekt ist State, Model, View und Controller gleichzeitig
 * Programmiersil hin oder her, aber 4 Klassen für das sind echt übertrieben
 * **/
public class loadingState implements State {

    //Ladeanimation
    private float time = 0f;
    private Animation<TextureRegion> animation;
    private Texture spriteSheet;
    //Hintergrund
    private Texture background;

    //Fake Laden
    State nextState;
    private long loadingTime;

    public loadingState(State nextState, long loadingTime){
        this.nextState = nextState;
        this.loadingTime = loadingTime;
    }

    @Override
    public void Show() {
        background = new Texture("misc/loadingback.png");
        //Animation
        spriteSheet = new Texture("misc/loadingSheet.png");
        //Sprietesheet wird in einzeltexturen zerlegt
        TextureRegion[] tr = TextureRegion.split(spriteSheet,
                spriteSheet.getWidth()/8,
                spriteSheet.getHeight()/1)[0];
        //8 Frames/ 1 Sekunde
        animation = new Animation<TextureRegion>(0.125f,tr);
    }

    @Override
    public void Render(SpriteBatch batch) {
        //Anzeigen des Hintergrundes
        batch.draw(background,0,0);
        //Anzeigen der Animation
        batch.draw(animation.getKeyFrame(time,true),1000,75);
        batch.draw(animation.getKeyFrame(time,true),125,75);
        batch.draw(animation.getKeyFrame(time,true),125,635);
        batch.draw(animation.getKeyFrame(time,true),1000,635);
    }

    @Override
    public void Update(float delta) {
        time+=delta;

        //Wenn die Zeit reif ist, wird der nächste Schritt geladen
        if (time >= loadingTime && nextState.load()){
            finished();
        }
    }

    @Override
    public boolean load() {
        return true;
    }

    @Override
    public void dispose() {
        spriteSheet.dispose();
        background.dispose();
    }

    public void finished(){
        //State wird gewechselt, wenn 2s verstrichen sind
        //Das Laden des nächsten States fängt nach dem Beenden des loading-Screens statt
        //Der Loadingscreen ist komplett nutzlos!
        StateEngine.getInstance().SwitchState(nextState);
    }
}
