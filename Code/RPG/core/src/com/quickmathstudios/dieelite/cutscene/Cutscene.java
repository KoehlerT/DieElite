package com.quickmathstudios.dieelite.cutscene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Cutscene implements Disposable {

    String resourcePath;
    Texture[] textures;
    int currentTexture = 0;

    public Cutscene(String name){
        resourcePath = "cutscenes/"+name+"/";
        getTextures(new File(resourcePath));
    }

    private void getTextures(File folder){
        File[] files =  folder.listFiles();
        List<Texture> textureList = new LinkedList<Texture>();

        for (int i = 0; i < files.length; i++){
            File file = files[i];
            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")){
                textureList.add(new Texture(resourcePath+file.getName()));
            }
        }

        textures = new Texture[textureList.size()];
        textureList.toArray(textures);

    }

    public Texture getTexture(){
        return textures[currentTexture];
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
