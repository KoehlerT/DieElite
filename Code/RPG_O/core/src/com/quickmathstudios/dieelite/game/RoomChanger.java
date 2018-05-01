package com.quickmathstudios.dieelite.game;

import com.quickmathstudios.dieelite.game.rooms.Room;

/**Stateengine für Spielräume
 *
* **/
public class RoomChanger {
    //Singleton
    private static RoomChanger ourInstance;

    public static RoomChanger getInstance() {
        return ourInstance;
    }

    private Room current;

    public RoomChanger() {
        ourInstance = this;
    }

    //Getter
    public Room getCurrent(){
        return current;
    }

    //Raumwechsel
    public void changeRoom(Room newRoom){
        if (current != null)
            current.dispose();
        current = newRoom;
    }

    public void dispose(){
        //Arbeisspeicher freigbenen
        ourInstance = null; //Freigabe zum Garbage Collecten
    }
}
