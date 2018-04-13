package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;

public class Traber extends Interactable{

    Texture t;
    Texture alias;
    public Traber(){
        super(50,200);
        t = new Texture("traber.png");
        alias = new Texture("traberAlias.png");
        this.position = new Vector2(50,200);
    }

    @Override
    public void interact() {
        Message root = new Message("Grüß Gott",alias,new Message[]{new SimpleMessage("VERWEIß",alias,null),new SimpleMessage("Toll",alias,null)},new String[]{"Opfer","Hallo"});
        CurrentDialogue.getInstance().addDialogue(root);
    }

    @Override
    public Texture getTexture() {
        return t;
    }

    @Override
    public void dispose(){
        t.dispose();
        alias.dispose();
    }
}
