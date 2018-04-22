package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

public class DialogueController implements Observer {

    public DialogueController(){
        MouseClick.getInstance().addObserver(this);
    }


    public void dispose(){
        MouseClick.getInstance().deleteObserver(this);
    }

    @Override
    public void Update(Observable observable, Object sender) {
        if (observable instanceof MouseClick) {
            MouseClick mouseInfo = (MouseClick) observable;
            //Check, which option is clicked
            Vector2 cursor = mouseInfo.getPosition();
            if (cursor.x > 950 && cursor.y < 150 && cursor.x<1150&&cursor.y>50){
                //Cursor befindet sich in der Optionen box
                int index = (int)((cursor.y-50)/25f);
                index = 3-index;
                CurrentDialogue.getInstance().next(index);
            }

        }
    }
}
