package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import com.quickmathstudios.dieelite.game.interactables.Interactable;

import java.io.File;
import java.util.*;

public class Cutscene implements Disposable {

    String resourcePath;
    Texture[] textures;
    int currentTexture = 0;

    //LOADING
    String[] files;
    List<Texture> textureList = new LinkedList<Texture>();
    int loaded = 0;

    Map<Integer,String> messages = new HashMap<Integer, String>();

    public Cutscene(String name){
        resourcePath = "cutscenes/"+name+"/";
        files = Gdx.files.internal(resourcePath+"files.txt").readString("UTF-8").split("\\n");
        String[] messageFile = Gdx.files.internal(resourcePath+"dia.txt").readString("UTF-8").split("\\n");
        getMessages(messageFile);
    }

    private void getMessages(String[] file){
        for (int i = 0; i < file.length; i++){

            String[] parts = file[i].split("§");
            String numberPart = parts[0].replaceAll(Character.toString((char)65279),"").replaceAll("[^\\d]","");
            Integer frame = (Integer)Integer.parseInt(numberPart);
            messages.put(frame,parts[1].replaceAll("%","\n"));
        }
    }


    private void getTextures(String resourcePath, int loaded){
        for (int i = loaded; i < loaded + 10 && i < files.length; i++){
            textureList.add(new Texture(resourcePath+files[i].substring(0,13)));

        }


    }

    public boolean load(){

        getTextures(resourcePath,loaded);
        loaded += 10;

        if (loaded >= files.length){
            textures = new Texture[textureList.size()];
            textureList.toArray(textures);
            return true;
        }

        return false;

    }

    public Texture getTexture(){
        return textures[currentTexture];
    }

    public String getMessage(){
        return messages.get(currentTexture);
    }

    public boolean nextStep(){
        currentTexture ++;
        return  (currentTexture < textures.length);
    }

    public void updateLogic(float time){

    }

    public boolean finished() {
        return (currentTexture >= textures.length-1);
    }

    @Override
    public void dispose() {
        for (int i = 0; i < textures.length; i++){
            textures[i].dispose();
        }
    }
}
