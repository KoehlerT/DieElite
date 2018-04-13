package com.quickmathstudios.dieelite.game;

import com.quickmathstudios.dieelite.game.rooms.Room;

public class RoomChanger {
    private static RoomChanger ourInstance;

    public static RoomChanger getInstance() {
        return ourInstance;
    }

    private Room current;

    public RoomChanger() {
        ourInstance = this;
    }

    public Room getCurrent(){
        return current;
    }

    public void changeRoom(Room newRoom){
        if (current != null)
            current.dispose();
        current = newRoom;
    }

    public void dispose(){
        ourInstance = null; //Freigabe zum Garbage Collecten
    }
}
