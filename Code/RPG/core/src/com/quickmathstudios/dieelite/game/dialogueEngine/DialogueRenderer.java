package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;

/**Zeigt das Dialog-Interface an
 * **/
public class DialogueRenderer {

    BitmapFont font;
    Texture dialogueBackgound;
    Texture defaultAlias;

    public DialogueRenderer(){
        font = new BitmapFont();
        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
        dialogueBackgound = new Texture("dialogueBackground.png");
        defaultAlias = new Texture("defaultAlias.png");
    }

    public void draw(SpriteBatch batch){
        Message toDisplay = CurrentDialogue.getInstance().getCurrent();
        if (toDisplay == null)
            return;
        batch.draw(dialogueBackgound,0,0);
        Texture alias = (toDisplay.getAlias() == null)?defaultAlias:toDisplay.getAlias();
        batch.draw(alias,50,50);
        font.draw(batch,toDisplay.getContent(),200,100);
        //Draw Interaction Options
        String[] options = toDisplay.getOptions();
        for (int i = 0; i<options.length;i++){
            font.draw(batch,options[i],1000,150-(i*20));
        }

    }

    public void dispose(){
        dialogueBackgound.dispose();
        defaultAlias.dispose();
    }
}
