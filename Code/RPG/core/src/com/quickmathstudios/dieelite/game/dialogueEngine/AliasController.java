package com.quickmathstudios.dieelite.game.dialogueEngine;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class AliasController implements Disposable {

    Texture defaultAlias;

    Map<String,Texture> list = new HashMap<String,Texture>();

    public AliasController(){
        defaultAlias = new Texture("alias/default.png");
        fillMap();
    }

    public Texture getAlias(String id){
        if (list.containsKey(id))
            return list.get(id);
        else
            return defaultAlias;
    }

    private void fillMap(){
        list.put("bernweich",new Texture("alias/bernweich.png"));
        list.put("traber",new Texture("alias/traber.png"));
        list.put("player",new Texture("alias/player.png"));
        list.put("butter",new Texture("alias/butter.png"));
        list.put("manu",new Texture("alias/manu.png"));
        list.put("kehrmain",new Texture("alias/kehrmain.png"));
        list.put("leopard",new Texture("alias/leopard.png"));
        list.put("mum",new Texture("alias/mum.png"));
    }

    @Override
    public void dispose() {
        defaultAlias.dispose();
        list.forEach(new BiConsumer<String, Texture>() {
            @Override
            public void accept(String s, Texture texture) {
                texture.dispose();
            }
        });
    }
}
