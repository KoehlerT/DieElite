package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.input.MouseClick;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

public class CutsceneController implements Observer, Disposable {

    Cutscene cutscene;

    public CutsceneController(Cutscene cutscene){
        MouseClick.getInstance().addObserver(this);
        this.cutscene = cutscene;
    }

    @Override
    public void Update(Observable observable, Object sender) {
        if (observable instanceof MouseClick) {
            MouseClick mo = (MouseClick) observable;
            if (!cutscene.nextStep()){
                System.out.println("Next Story");
                StoryEngine.getInstance().updateStory();
            }
        }

        String message = cutscene.getMessage();
        if (message!= null)
            workMessage(message);
    }

    private void workMessage(String msg){
        if (msg.contains("STOP")){
            CurrentDialogue.getInstance().addDialogue(null);
        }else {
            CurrentDialogue.getInstance().addDialogue(new SimpleMessage(msg, null, null));
        }

    }

    public void updateLogic(float time){
        cutscene.updateLogic(time);
    }


    @Override
    public void dispose() {
        MouseClick.getInstance().deleteObserver(this);
    }
}
