package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.game.rooms.Classroom1;
import com.quickmathstudios.dieelite.game.rooms.CorridorBase;
import com.quickmathstudios.dieelite.utillity.State;

/**GameState
 * Von der Stateengine Aufgerufen
 * Instanziiert Die Model- View- und Controller-Objekte
 * Der Raumwechlser wird instanziiiert
 * Das Spielerobjekt wird eingerichtet
 * **/
public class GameState implements State {
    private RoomChanger roomChanger;
    private GameRenderer gameRenderer;
    private GameController gameController;
    private Player player;

    @Override
    public void Show() {
        player = new Player();
        roomChanger = new RoomChanger();
        gameRenderer = new GameRenderer();
        gameController = new GameController();
        StoryEngine.getInstance().updateStory();
    }

    @Override
    public void Render(SpriteBatch batch) {
        //Anzeigen des Spiels
        gameRenderer.Render(batch);
    }

    @Override
    public void Update(float delta) {
        //Logikaktualisierungen des States
        gameController.UpdateLogic(delta);
    }

    @Override
    public void dispose() {
        //Arbeitsspeicher freigeben
        roomChanger.dispose();
        gameController.dispose();
        player.dispose();
    }
}
