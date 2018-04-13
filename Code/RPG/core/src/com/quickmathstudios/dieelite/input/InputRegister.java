package com.quickmathstudios.dieelite.input;

import com.badlogic.gdx.InputProcessor;
import com.quickmathstudios.dieelite.main.Info;

public class InputRegister implements InputProcessor {

    private MouseInfo mouseInfo;

    public InputRegister(){
        mouseInfo = new MouseInfo();
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
        if(button ==0 && pointer == 0){
            mouseInfo.updateKoordinates(x, Info.Height-y); //Normalisieren, Unten Links 0,0
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
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
