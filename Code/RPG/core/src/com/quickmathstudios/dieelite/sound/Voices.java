package com.quickmathstudios.dieelite.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Disposable;

public class Voices implements Disposable {

    private Sound[] voices;
    private Sound currentlyPlayning;

    public Voices(){
        getVoices();
    }

    public void playSoundById(int id){
        if (id >= 0 && id < voices.length){
            if (currentlyPlayning != null)
                currentlyPlayning.stop();
            currentlyPlayning = voices[id];
            currentlyPlayning.play();
        }
    }


    private void getVoices(){
        voices = new Sound[32];
        voices[0] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/TraberHolen.mp3"));
        voices[1] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/TraberJa.mp3"));
        voices[2] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/TraberNein.mp3"));
        voices[3] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/TraberEnde.mp3"));
        voices[4] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Bernweich.mp3"));
        voices[5] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/LeopardKab.mp3"));
        voices[6] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/KehrmainSoz.mp3"));
        voices[7] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Manu.mp3"));
        voices[8] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterRuder.mp3"));
        voices[9] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterGut.mp3"));
        voices[10] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterSchlecht.mp3"));
        voices[11] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Butter8Geh.mp3"));
        voices[12] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Butter10Ja.mp3"));
        voices[13] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Butter10KommNah.mp3"));
        voices[14] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Butter10Komm.mp3"));
        voices[15] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/Butter10Gebet.mp3"));
        voices[16] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/DevDeny.mp3"));
        voices[17] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/DevGnade.mp3"));
        voices[18] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/KevinHu.mp3"));
        voices[19] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/KevinNein.mp3"));
        voices[20] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/KevinHund.mp3"));
        voices[21] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/KevinJa.mp3"));
        voices[22] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/MumHallo.mp3"));
        voices[23] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuKommen.mp3"));
        voices[24] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuAufs.mp3"));
        voices[25] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuSchlecht.mp3"));
        voices[26] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuSchreiben.mp3"));
        voices[27] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuAusr.mp3"));
        voices[28] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ButterQuEwig.mp3"));
        voices[29] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/BernweichVert.mp3"));
        voices[30] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/BernweichKevin.mp3"));
        voices[31] = Gdx.audio.newSound(Gdx.files.internal("sound/voice/ManuWeg.mp3"));

    }

    @Override
    public void dispose() {
        for (int i = 0; i < voices.length; i++){
            voices[i].dispose();
        }
    }
}
