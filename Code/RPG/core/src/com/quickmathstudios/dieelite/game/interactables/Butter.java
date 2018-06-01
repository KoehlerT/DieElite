package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class Butter extends Interactable {
    private Texture alias;

    public Butter(Vector2 position){
        super(new Texture("entities/butter.png"),
                new HitBox(position, new Vector2(100, 200).add(position)),
                new HitBox(position, new Vector2(150, 250).add(position)),
                null);
        this.position = position;
        alias = new Texture("entities/butterAlias.png");
    }

    private Message getDialogue(){
        Message root = new SimpleMessage("Ruder Kevin",alias,null);

        return root;
    }

    @Override
    public void interact() {
        CurrentDialogue.getInstance().addDialogue(getDialogue());
    }

    @Override
    public void dispose() {
        super.dispose();
        alias.dispose();
    }
}
