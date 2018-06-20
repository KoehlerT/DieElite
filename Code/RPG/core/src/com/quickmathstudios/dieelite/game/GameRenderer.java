package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueRenderer;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.game.rooms.Room;

/**Zeigt den Aktuellen Raum an
 * **/
public class GameRenderer implements Disposable {

    private DialogueRenderer dialogueRenderer;
    private float animationTime;

    public GameRenderer(){
        dialogueRenderer = new DialogueRenderer();
    }

    public void Render(SpriteBatch batch){
        animationTime += Gdx.graphics.getDeltaTime();
        Room toRender = RoomChanger.getInstance().getCurrent();
        Player player = Player.getInstance();
        batch.draw(toRender.getBackground(),0,0);
        batch.draw(player.getRegion(animationTime),player.getX(),player.getY());

        //Interactables
        Interactable[] ints = toRender.getInteractables();
        for( Interactable i : ints){
            TextureRegion tr = i.getTexture();
            if (tr != null)
                batch.draw(tr, i.getPosition().x,i.getPosition().y);
        }

        //Dialogues
        dialogueRenderer.draw(batch);
    }

    @Override
    public void dispose() {
        dialogueRenderer.dispose();
    }
}
