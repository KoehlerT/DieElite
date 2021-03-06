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
                StoryEngine.getInstance().updateStory();
            }
        }

    }

    private void workMessage(String msg){
        if (msg.contains("STOP")){
            CurrentDialogue.getInstance().addDialogue(null);
        }else {
            String alias = "default";
            int voiceId = -1;

            if (msg.contains("&")){
                String[] sp = msg.split("&");
                if (sp.length == 2){
                    alias = sp[0];
                    msg = sp[1];
                }else if (sp.length == 3){
                    alias = sp[0];
                    voiceId = Integer.parseInt(sp[1].replaceAll("[^\\d]",""));//Sicher gehen, dass da kein Müll dabei ist!
                    msg = sp[2];
                }

            }
            CurrentDialogue.getInstance().addDialogue(new SimpleMessage(msg, alias,voiceId, null));
        }

    }

    public void updateLogic(float time){
        cutscene.updateLogic(time);
        String message = cutscene.getMessage();
        if (message!= null)
            workMessage(message);
    }


    @Override
    public void dispose() {
        MouseClick.getInstance().deleteObserver(this);
    }
}
