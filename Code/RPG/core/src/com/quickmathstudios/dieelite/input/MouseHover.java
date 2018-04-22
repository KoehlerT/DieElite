package com.quickmathstudios.dieelite.input;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.util.LinkedList;
import java.util.List;

public class MouseHover implements Observable {

    private static MouseHover instance;
    public static MouseHover getInstance(){return instance;}

    private List<Observer> observers = new LinkedList<Observer>();
    private Vector2 position = new Vector2();

    MouseHover(){instance = this;}

    public Vector2 getPosition(){
        return position;
    }

    void updateCoordinates(int x, int y){
        position.x = x;
        position.y = y;
        notifyObservers();
    }

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
