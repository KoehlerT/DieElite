package com.quickmathstudios.dieelite.input;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.util.LinkedList;
import java.util.List;

/**Klasse zum Erhalten von Mausbewegungen
 * **/
public class MouseHover implements Observable {

    //Singleton
    private static MouseHover instance;
    public static MouseHover getInstance(){return instance;}

    //Liste der Beobachtenden
    private List<Observer> observers = new LinkedList<Observer>();
    private Vector2 position = new Vector2(); //Position der Maus

    MouseHover(){instance = this;}

    //Getter
    public Vector2 getPosition(){
        return position;
    }

    //Position wird Aktualisiert
    void updateCoordinates(int x, int y){

        position.x = x;
        position.y = y;
        notifyObservers();
    }


    //Observable Stuff
    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void deleteObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void deleteObservers() {
        observers.clear();
    }

    @Override
    public int countObservers() {
        return observers.size();
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.Update(this,this);
        }
    }
}
