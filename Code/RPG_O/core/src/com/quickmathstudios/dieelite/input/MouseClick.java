package com.quickmathstudios.dieelite.input;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.util.LinkedList;
import java.util.List;

public class MouseClick implements Observable {

    //Singleton
    private static MouseClick instance;
    public static MouseClick getInstance(){return instance;}

    //Liste der Beobachtenden
    private List<Observer> observers = new LinkedList<Observer>();
    
    private int x;
    private int y;
    private Vector2 position;

    public MouseClick(){
        instance = this;
        position = new Vector2(x,y);
    }
    
    void updateKoordinates(int x, int y){
        //Koordinaten werden aktualisiert
        this.x = x;
        this.y = y;
        position.x = (float)x;
        position.y = (float)y;
        //Die Beobachtenden werden informiert
        notifyObservers();
    }

    //Getter
    public int getX(){return x;}
    public int getY(){return y;}
    public Vector2 getPosition(){return position;}
    
    //Observable
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
            if (o != null)
                o.Update(this,this);
        }
    }
}
