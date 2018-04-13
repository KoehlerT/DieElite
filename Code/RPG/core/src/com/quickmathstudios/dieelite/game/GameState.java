package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.game.rooms.CorridorBase;
import com.quickmathstudios.dieelite.utillity.State;

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
        roomChanger.changeRoom(new CorridorBase());
    }

    @Override
    public void Render(SpriteBatch batch) {
        gameRenderer.Render(batch);
    }

    @Override
    public void Update(float delta) {
        gameController.UpdateLogic(delta);
    }

    @Override
    public void dispose() {
        gameController.dispose();
        player.dispose();
    }
}
