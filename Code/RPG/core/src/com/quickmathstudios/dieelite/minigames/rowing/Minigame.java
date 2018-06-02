package com.quickmathstudios.dieelite.minigames.rowing;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.minigames.rowing.swimming.Chainsaw;
import com.quickmathstudios.dieelite.minigames.rowing.swimming.Fish;
import com.quickmathstudios.dieelite.minigames.rowing.swimming.SwimmingObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class FrameLocation{
    public FrameLocation(TextureRegion tr, Vector2 vec){
        frame = tr; location = vec;
    }

    public TextureRegion frame;
    public Vector2 location;
}

public class Minigame implements Disposable {

    private Texture background;
    private float animationTime = 0f;

    private PlayerFish player;
    private int Score = 0;

    private ArrayList<SwimmingObject> swimmingObjects = new ArrayList<>();
    private Random random = new Random();

    public Minigame(){
        background = new Texture("minigames/row/background.jpg");
        player = new PlayerFish();
    }

    //Controlling

    public List<SwimmingObject> getObjects(){
        return swimmingObjects;
    }

    public PlayerFish getPlayer() {
        return player;
    }

    public void SpawnObject(int identifier){
        int height = random.nextInt(700);
        if (identifier == 0){
            swimmingObjects.add(new Fish(height));
        }else if (identifier == 1){
            swimmingObjects.add(new Chainsaw(height));
        }
    }

    public void incrementAnimationtime(float increment) {
        this.animationTime +=increment;
    }

    public void incrementScore(int increment){
        this.Score += increment;
    }

    //Getter
    public Texture getBackground(){
        return background;
    }

    public FrameLocation[] getFrameLocations(){
        FrameLocation[] result = new FrameLocation[1+swimmingObjects.size()];

        result[0] = new FrameLocation(player.getTextureRegion(animationTime),player.getLocation());

        for (int i = 0; i < swimmingObjects.size(); i++){
            result[i+1] = new FrameLocation(swimmingObjects.get(i).getTextureRegion(animationTime),swimmingObjects.get(i).getLocation());
        }

        return result;
    }

    public int getScore() {
        return Score;
    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
