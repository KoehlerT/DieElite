package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueRenderer;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.game.rooms.Room;

public class GameRenderer {

    public DialogueRenderer dialogueRenderer;

    public GameRenderer(){
        dialogueRenderer = new DialogueRenderer();
    }

    public void Render(SpriteBatch batch){
        Room toRender = RoomChanger.getInstance().getCurrent();
        Player player = Player.getInstance();
        batch.draw(toRender.getBackground(),0,0);
        batch.draw(player.getTexture(),player.getX(),player.getY());

        //Interactables
        Interactable[] ints = toRender.getInteractables();
        for( Interactable i : ints) batch.draw(i.getTexture(), i.getPosition().x,i.getPosition().y);

        //Dialogues
        dialogueRenderer.draw(batch);
    }
}
