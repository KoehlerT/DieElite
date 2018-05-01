package com.quickmathstudios.dieelite.main;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.utils.Disposable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**Der Soundmanager Spielt alle Soundeffekte und Hintergrundmusiken ab
 * Dieses Objekt hält alle Referenzen zu den Musikobjekten!
 * **/
public class SoundManager implements Disposable {
    //Singleton
    private static SoundManager ourInstance = new SoundManager();

    public static SoundManager getInstance() {
        return ourInstance;
    }

    //Musikmanagement
    private Music currentBackground;
    private Music[] musics = new Music[1];

    //Alle Soundeffekte
    private Map<String,Sound> soundMap = new HashMap<String, Sound>();

    private SoundManager() {
        //Befülle das Musikarray
        musics[0] = Gdx.audio.newMusic(Gdx.files.internal("sound/background/default.mp3"));
        musics[0].setLooping(true);
        musics[0].setVolume(0.5f);

        loadSounds(); //Befülle die Soundsmap
        switchBackground(0);
    }

    public void playBackground(){
        currentBackground.play();
    }

    public void pauseBackground(){
        currentBackground.pause();
    }

    /**Zum einfachen Abspielen von Soundeffekten.
     * **/
    public void playSoundByName(String name){
        soundMap.get(name).play();
    }

    /**Ändert die Hintergrundmusik zu einem neuen Thema
     * **/
    public void switchBackground(int musicId){
        if (currentBackground != null){
            currentBackground.stop();
        }

        if (musicId < 0 || musicId >= musics.length){
            throw new RuntimeException("Fehler beim ändern der Musik");
        }
        currentBackground = musics[musicId];
        currentBackground.play();

    }

    //PRIVATE METHODS
    private void loadSounds(){
        soundMap.put("hover",Gdx.audio.newSound(Gdx.files.internal("sound/menu/hover.wav")));
        soundMap.put("click",Gdx.audio.newSound(Gdx.files.internal("sound/menu/click.wav")));
    }


    @Override
    public void dispose() {
        for (int i = 0; i < musics.length; i++){
            musics[i].dispose();
        }

        soundMap.forEach(new BiConsumer<String, Sound>() {
            @Override
            public void accept(String s, Sound sound) {
                sound.dispose();
            }
        });
    }
}
