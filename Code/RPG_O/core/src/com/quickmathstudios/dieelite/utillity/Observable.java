package com.quickmathstudios.dieelite.utillity;

public interface Observable {
    public void addObserver(Observer obs);
    public void deleteObserver(Observer obs);
    public void deleteObservers();
    public int countObservers();
    public void notifyObservers();

}
