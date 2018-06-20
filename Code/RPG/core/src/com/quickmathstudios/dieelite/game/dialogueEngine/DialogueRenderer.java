package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;

import java.awt.*;

/**Zeigt das Dialog-Interface an
 * **/
public class DialogueRenderer {

    BitmapFont font;
    Texture dialogueBackgound;
    AliasController aliasController;

    public DialogueRenderer(){
        aliasController = new AliasController();
        dialogueBackgound = new Texture("misc/dialogueBackground.png");


        //Generate Font
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
    }

    public void draw(SpriteBatch batch){
        Message toDisplay = CurrentDialogue.getInstance().getCurrent();
        if (toDisplay == null)
            return;
        batch.draw(dialogueBackgound,0,0);
        Texture alias = aliasController.getAlias(toDisplay.getAliasId());
        batch.draw(alias,50,50);

        //draw content
        String[] lines = getLines(toDisplay.getContent());
        for (int i = 0; i<lines.length;i++){
            font.draw(batch,lines[i],200,150-(i*30));
        }

        //Draw Interaction Options
        GlyphLayout gl = new GlyphLayout();
        String[] options = toDisplay.getOptions();
        for (int i = 0; i<options.length;i++){
            if (CurrentDialogue.getInstance().hovering() == i){
                gl.setText(font,options[i], Color.ORANGE,200,0,false);
            }else{
                gl.setText(font,options[i], Color.BLACK,200,0,false);
            }
            font.draw(batch,gl,890,150-(i*20));
        }

    }

    String[] getLines(String message){
        return message.split("\\n");
    }

    public void dispose(){
        dialogueBackgound.dispose();
        aliasController.dispose();
    }
}
