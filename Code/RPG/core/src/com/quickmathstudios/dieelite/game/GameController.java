package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.interactables.Interactable;
import com.quickmathstudios.dieelite.game.player.Player;
import com.quickmathstudios.dieelite.game.rooms.Room;
import com.quickmathstudios.dieelite.input.MouseInfo;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

public class GameController implements Observer {

    private DialogueController dialogueController;

    public GameController(){
        MouseInfo.getInstance().addObserver(this);
        Player.getInstance().setPosition(new Vector2(500,500));
        dialogueController = new DialogueController();
    }
    @Override
    public void Update(Observable observable, Object sender) {
        if (sender instanceof MouseInfo) {
            MouseInfo mouseInfo = (MouseInfo) sender;
            Vector2 cursor = mouseInfo.getPosition();
            boolean hasInteracted = false;

            //If Interactable -> Fokussieren
            Room current = RoomChanger.getInstance().getCurrent();
            Interactable[] ints = current.getInteractables();
            for(Interactable i : ints){
                if (i.isClicked(cursor)){
                    Player.getInstance().setAim(null);
                    Player.getInstance().setTarget(i);
                    hasInteracted = true;
                }
            }

            //Boden --> Bewegen
            if (!hasInteracted){
                Player.getInstance().setAim(cursor);
                Player.getInstance().setTarget(null);
            }
        }

    }

    private Vector2 move = new Vector2();
    public void UpdateLogic(float delta){
        Player player = Player.getInstance();
        //Player bewegen
        if (player.getAim() != null && !CurrentDialogue.getInstance().currentlyTalking()){
            move.set(player.getAim());
            move.sub(player.getPosition());
            if (move.len2() >= 25) { //Nur bewegen wenn ziel weiter als 5 pixel
                move.setLength2(1);
                move.scl(player.getSpeed());
                move.scl(delta);
                player.setPosition(move.add(player.getPosition()));
            }
        }

        //Interactable Range -> Action
        if (player.hasTarget()){
            if (player.getTarget().inRadius(player.getPosition())){
                player.getTarget().interact();
                player.setTarget(null);
            }
        }
    }

    public void dispose(){
        MouseInfo.getInstance().deleteObserver(this);
        dialogueController.dispose();
    }
}
