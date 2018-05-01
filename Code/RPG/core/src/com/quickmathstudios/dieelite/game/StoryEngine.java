package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.rooms.CorridorBase;
import com.quickmathstudios.dieelite.game.rooms.Secretary;

public class StoryEngine {
    private static StoryEngine ourInstance;

    public static StoryEngine getInstance() {
        return ourInstance;
    }

    private int storyState = 0;
    public StoryEngine() {
        ourInstance = this;
    }
    public void getstoryState() {
        if (storyState == 0) {
            RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(1100,250),(byte)0b0000_0010));
        }
        if(storyState == 1) {
            RoomChanger.getInstance().changeRoom(new Secretary());
        }


    }
    public void updateStory() {
        this.getstoryState();
        storyState++;
    }
}
