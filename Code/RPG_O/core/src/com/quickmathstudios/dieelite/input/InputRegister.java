package com.quickmathstudios.dieelite.input;

import com.badlogic.gdx.InputProcessor;
import com.quickmathstudios.dieelite.main.Info;
/**Klasse zum bearbeiten der Inputs
 * Die interessanten Elemente werden an die zuständigen, beobachtbaren Objekte weitergegeben
 * **/
public class InputRegister implements InputProcessor {

    private MouseClick mouseClick; //Observable für Mausklicks
    private MouseHover mouseHover; //Observable für Mausbewegungen

    public InputRegister(){
        //Instanziieren der Beobachtbaren Objekte
        mouseClick = new MouseClick();
        mouseHover = new MouseHover();
    }
    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        //Methode für Mausklicks (Und Touchscreen eingaben)
        if(button ==0 && pointer == 0){
            //Clicks werden als Koordinaten von Oben Links angegeben
            //Das Spiel arbeitet mit einem Koordinatensystem von Unten Links (ursprung)
            mouseClick.updateKoordinates(x, Info.Height-y); //Normalisieren, Unten Links 0,0
        }
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        //Methode für Mausbewegungen

        //Clicks werden als Koordinaten von Oben Links angegeben
        //Das Spiel arbeitet mit einem Koordinatensystem von Unten Links (ursprung)
        mouseHover.updateCoordinates(i,Info.Height-i1);
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
