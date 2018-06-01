package com.quickmathstudios.dieelite.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.loadingScreen.loadingState;
import com.quickmathstudios.dieelite.utillity.State;

public class StateEngine {

    //Singleton
    private static StateEngine instance;
    public static StateEngine getInstance(){return instance;}

    private State currentState;

    public StateEngine(){
        instance = this;
    }




    /**Schnittstelle zum Engineobjekt
     * Wird jeden Frame aufgerufen
     * **/
    public void renderState(SpriteBatch b){
        if (currentState == null)
            return;
        /**
         * Trennen der Anzeige und Update Methode
         * Wichtig für das Model-View-Controller Schema
         * View: Render
         * Controller: Update
         */
        float delta = Gdx.graphics.getDeltaTime();
        currentState.Update(delta); //Logik des States wird aktualisiert
        currentState.Render(b);  //Der aktuelle State wird angezeigt

    }


    /**Ändern des Gamestates
     * **/
    public void SwitchState(State next){
        if (currentState != null){
            currentState.dispose(); //Aktueller State wird aufgelöst -> Arbeitsspeicher freigeben
        }
        //Ändern des States
        next.Show();
        currentState = next;


        System.out.println("Switched State to: "+currentState);
    }

    public void disposeEngine(){
        currentState.dispose();
    }

}
