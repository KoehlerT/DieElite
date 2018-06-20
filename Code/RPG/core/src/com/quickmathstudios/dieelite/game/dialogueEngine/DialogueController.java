package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.input.MouseHover;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.awt.event.MouseAdapter;

/**Kontrolliert intaraktionen des Spielers mit dem Dialoginterface
 * **/
public class DialogueController implements Observer {

    public DialogueController(){
        MouseClick.getInstance().addObserver(this);
        MouseHover.getInstance().addObserver(this);
    } //Mausklicks Beobachten


    public void dispose(){
        MouseClick.getInstance().deleteObserver(this);
        MouseHover.getInstance().deleteObserver(this);
    } //Mausklick Beobachtung beenden

    @Override
    public void Update(Observable observable, Object sender) {
        if (observable instanceof MouseClick) {
            MouseClick mouseInfo = (MouseClick) observable;
            //Check, which option is clicked
            Vector2 cursor = mouseInfo.getPosition();
            CurrentDialogue.getInstance().next(indexFromLocation(cursor));

        }
        if (observable instanceof MouseHover) {
            MouseHover mouseHover = (MouseHover) observable;
            Vector2 cursor = mouseHover.getPosition();
            CurrentDialogue.getInstance().setHovering(indexFromLocation(cursor));
        }
    }

    int indexFromLocation(Vector2 location){
        if (location.x > 950 && location.y < 150 && location.x<1150&&location.y>10){
            //Cursor befindet sich in der Optionen box
            int index = (int)((location.y-50)/25f); //Index Berechnen
            index = 3-index; //Idex Invertieren
            return index;
        }
        return -1;
    }
}
