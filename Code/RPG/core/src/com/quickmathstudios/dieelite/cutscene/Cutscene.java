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
        files = Gdx.files.internal(resourcePath+"files.txt").readString().split("\\n");
        String[] messageFile = Gdx.files.internal(resourcePath+"dia.txt").readString().split("\\n");
        getMessages(messageFile);

    }

    private void getMessages(String[] file){
        for (int i = 0; i < file.length; i++){
            String[] parts = file[i].split("§");
            Integer frame = (Integer)Integer.parseInt(parts[0].replaceAll(Character.toString((char)65279),""));
            messages.put(frame,parts[1]);
        }
    }

    private void getTextures(String resourcePath, int loaded){
        //System.out.println((int)files[0].toCharArray()[5]);


        for (int i = loaded; i < loaded + 10 && i < files.length; i++){
            System.out.println(resourcePath+files[i]);
            textureList.add(new Texture(resourcePath+files[i]));

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
        //System.out.println(currentTexture+" "+textures.length+" "+(currentTexture < textures.length));
        return  (currentTexture < textures.length);
    }

    public void updateLogic(float time){

    }

    @Override
    public void dispose() {
        for (int i = 0; i < textures.length; i++){
            textures[i].dispose();
        }
    }
}
