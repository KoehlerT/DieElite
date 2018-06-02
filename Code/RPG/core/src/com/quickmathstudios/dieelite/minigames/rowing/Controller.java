package com.quickmathstudios.dieelite.minigames.rowing;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.input.MouseHover;
import com.quickmathstudios.dieelite.minigames.rowing.swimming.SwimmingObject;
import com.quickmathstudios.dieelite.utillity.Observable;
import com.quickmathstudios.dieelite.utillity.Observer;

import java.util.List;
import java.util.Random;

public class Controller implements Disposable, Observer {

    private static final float fischProSek = 1f;
    private static final float playTime = 60;
    private static final int mark = -200;

    Minigame toControl;
    private double runtime = 0;
    Random random = new Random();

    Controller(Minigame minigame){
        toControl = minigame;
        MouseHover.getInstance().addObserver(this);

        toControl.SpawnObject(0);
        toControl.SpawnObject(1);
    }

    public void UpdateLogic(float delta){
        runtime += delta;

        toControl.incrementAnimationtime(delta);

        PlayerFish player = toControl.getPlayer();
        List<SwimmingObject> objects = toControl.getObjects();
        //Move Objects
        player.move(delta);
        for (SwimmingObject s : objects)
            s.updateLocation(delta,getSpeedMultiplier());

        //Check collisions
        for (int i = objects.size()-1; i >= 0; i--){
            if (objects.get(i).getHitbox().intersects(player.getHitbox())){
                //Treffer
                System.out.println("TREFFER");
                SwimmingObject object = objects.get(i);

                if (object.isEdible()){
                    toControl.incrementScore(10);
                }else{
                    toControl.incrementScore(-20);
                }

                removeObjectFromList(objects,i);
            }

            if (objects.size() > i)//Wenn außerhalb des Bildschirms
                if (objects.get(i).getLocation().x < -300)
                    removeObjectFromList(objects,i); //entfernen
        }


        if (runtime >= playTime){
            gameOver();
        }

        //Spawne Fische
        SpawnFish(delta);

    }

    private void removeObjectFromList(List<SwimmingObject> list, int toRemove){
        list.get(toRemove).dispose();
        list.remove(toRemove);

    }

    private float getSpeedMultiplier(){
        //Code um die Spielgeschwindigkeit mit der Runtime wachsen zu lassen!
        return 1f;
    }

    private void SpawnFish(float deltaTime){
        //Wahscheinlichkeit wird größer, je länger der Frame ist
        float wahrsch = fischProSek * deltaTime; //Wie viele Fische sollen diesen Frame spawnen
        float randomNum = random.nextFloat();
        if (wahrsch > randomNum){
            //Fisch wird spawnen
            //50/50 chance welcher Fisch
            toControl.SpawnObject(random.nextInt(2));
        }

    }

    private void gameOver(){
        System.out.println("Game Over, Score: "+toControl.getScore());
        if( toControl.getScore() > mark)
            StoryEngine.getInstance().setBranch(1);
        else
            StoryEngine.getInstance().setBranch(0);

        StoryEngine.getInstance().updateStory();
    }

    @Override
    public void dispose() {
        MouseHover.getInstance().deleteObserver(this);
    }

    private long lastMove = 0;
    private Vector2 lastPosition = new Vector2();
    private float speed;

    @Override
    public void Update(Observable observable, Object sender) {
        if (observable instanceof MouseHover) {
            MouseHover mo = (MouseHover) observable;

            if (lastMove == 0){
                lastMove = System.nanoTime();
                lastPosition.set(mo.getPosition());
                return;
            }
            final Vector2 position = mo.getPosition();
            Vector2 dist = new Vector2();

            //Calculate Speed
            dist.set(position).sub(lastPosition); //Vektor der Distanz errechnen
            float length = dist.y; //Länge des Vektors (nur Vertikale Komponente)
            float time = (float)(System.nanoTime()-lastMove)/1_000_000_000f; //Die Zeit, in der die Länge zurückgelegt wurde
            speed = length/time;//-> Geschwindigkeit
            toControl.getPlayer().addSpeed(Math.abs(speed)*0.00001f); //Geschwindikeit ein bisschen runterskaliert -> Schwerer
            lastPosition.set(position); //Für nächste Berechnung vorbereiten
            lastMove = System.nanoTime();//Für nächste Berechnung vorbeoereiten
        }
    }
}
