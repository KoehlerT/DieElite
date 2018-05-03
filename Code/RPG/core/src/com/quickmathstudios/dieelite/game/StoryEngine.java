package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.rooms.*;

public class StoryEngine {
    private static StoryEngine ourInstance;

    public static StoryEngine getInstance() {
        return ourInstance;
    }

    private int step = 0;
    private int chapter = 0;

    public StoryEngine() {
        ourInstance = this;
    }
    public void getstoryState() {


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
