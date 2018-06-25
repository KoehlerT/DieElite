package com.quickmathstudios.dieelite.sound;

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
    private Music[] musics = new Music[2];
    Voices voices;

    //Alle Soundeffekte
    private Map<String,Sound> soundMap = new HashMap<String, Sound>();

    private SoundManager() {
        //Befülle das Musikarray
        loadBackgrounds();
        voices = new Voices();
        loadSounds(); //Befülle die Soundsmap
        switchBackground(1);
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
        if (musicId < 0 || musicId >= musics.length){
            throw new RuntimeException("Fehler beim ändern der Musik");
        }

        if (currentBackground == musics[musicId])
            return;

        if (currentBackground != null){
            currentBackground.stop();
        }

        currentBackground = musics[musicId];
        currentBackground.play();

    }

    public void playVoiceById(int id){
        voices.playSoundById(id);
    }

    //PRIVATE METHODS
    private void loadSounds(){
        soundMap.put("hover",Gdx.audio.newSound(Gdx.files.internal("sound/menu/hover.wav")));
        soundMap.put("click",Gdx.audio.newSound(Gdx.files.internal("sound/menu/click.wav")));
    }

    private void loadBackgrounds(){
        musics[0] = Gdx.audio.newMusic(Gdx.files.internal("sound/background/default.mp3"));
        musics[1] = Gdx.audio.newMusic(Gdx.files.internal("sound/background/menu.mp3"));

        for (int i = 0; i < musics.length; i++){
            musics[i].setLooping(true);
            musics[i].setVolume(0.5f);
        }
    }


    @Override
    public void dispose() {
        voices.dispose();
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
