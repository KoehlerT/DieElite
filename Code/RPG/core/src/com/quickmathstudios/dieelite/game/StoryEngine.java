package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.cutscene.Cutscene;
import com.quickmathstudios.dieelite.cutscene.CutsceneState;
import com.quickmathstudios.dieelite.game.rooms.*;
import com.quickmathstudios.dieelite.loadingScreen.loadingState;
import com.quickmathstudios.dieelite.main.StateEngine;

public class StoryEngine {
    private static StoryEngine ourInstance = new StoryEngine();

    public static StoryEngine getInstance() {
        return ourInstance;
    }

    private int step = 0;
    private int chapter = 1;

    private StoryEngine() {
        ourInstance = this;
    }
    public void getstoryState() {
        System.out.println(chapter+"/"+step);
        if (chapter == 0){
            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Classroom1());
            }
            if (step == 1) {
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(1100,250),(byte)0b0000_0010));
            }
            if(step == 2) {
                RoomChanger.getInstance().changeRoom(new Secretary());
            }else if (step == 3){
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(100,100), (byte) 0b0000_1000));
            }else if (step == 4){
                //Nach Kreide Holen zurück zu Traber
                System.out.println("Hi Traber");
                RoomChanger.getInstance().changeRoom(new Classroom1());
            }else if (step == 5) {
                //Kreide kommt zurück
                chapter = 1;
                step = 0;
                updateStory();
            }
        }else if (chapter == 1){
            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Classroom2());
            }if (step == 1){
                //Mit Frau bernweich geredet
                //Gong??

            }if (step == 2){
                //Klick auf Tür
                chapter = 2;
                step = 0;
                updateStory();
            }

        }else if (chapter == 2){
            /**
             * Kevin wird von Der Peiniger Verschleppt und mit Kabelbindern im Gang gefesselt.
             * Herr Leopard findet ihn und sagt, er solle keine Kabelbinder verwenden...
             */
            if (step == 0){
                StateEngine.getInstance().SwitchState(new loadingState(
                        new CutsceneState(
                                new Cutscene("chapter3")
                        ),1000));
            }
            //Step == 1: Gerade Cutscene schauen
            if (step == 2){
                System.out.println("Next chapter");
                chapter = 3;
                step = 0;
                StateEngine.getInstance().SwitchState(new loadingState(new GameState(),1000));
            }
        }else if (chapter == 3){
            if (step == 1){ //Warum?
                System.out.println("New Room");
                RoomChanger.getInstance().changeRoom(new Story4());
            }
        }



    }
    public void updateStory() {
        this.getstoryState();
        step++;
    }

    public int getChapter() {
        return chapter;
    }

    public int getStep() {
        return step;
    }
}
