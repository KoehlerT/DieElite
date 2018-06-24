package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.RoomChanger;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.game.rooms.ButterOffice;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;

public class ButterQuestion extends Interactable {
    String alias = "butter";
    boolean talked = false;

    public ButterQuestion(Vector2 position){
        super(new Texture("entities/butter.png"),
                position,
                null);
    }

    @Override
    public void interact() {
        Message root = fragen();
        if (!talked){
            root = talk(root);
            talked = true;
        }

        CurrentDialogue.getInstance().addDialogue(root);
    }

    private Message talk(Message frage){
        return new SimpleMessage("hallo Kevin, schön, dass du gekommen bist","butter",23,
                new SimpleMessage("Die Aufsätze die du mir letztens abgeliefert hast...","butter",24,
                        new SimpleMessage("Ja?","player",21,
                                new SimpleMessage("... sind echt schlecht!","butter",25,
                                        new SimpleMessage("Ich kann dir nur Raten:\n Schreiben lernt man nur durch Schreiben","butter",26,
                                                new SimpleMessage("und wenn du dich stark ins Zeug legst\n" +
                                                        "schaffst du vielleicht noch eine ausreichende Leistung","butter",27,
                                                                new SimpleMessage("Deshalb werden wir jetzt EWIG\n" +
                                                                        "deine Rechtschreibintuition trainieren.","butter",28,frage)))))));
    }

    private Message fragen(){
        Message fail = new SimpleMessage("Diese Antwort überzeugt mich \naufgrund der sprachlichen Schwächen nicht!","butter",null);

        return new Message("Ich habe einem Hipster ins Bein geschossen.\nJetzt Ho_ster","butter",new Message[]{
                fail,
                frage2(fail),
                fail
        },new String[]{"b","p","t"});
    }

    private Message frage2(Message fail){
        return  new Message("Ich werde Kassierer, damit ich\nsagen kann, ___ die Frauen bei mir\n schlange stehen","butter",
                new Message[]{fail,fail,frage3(fail)},
                new String[]{"das","damit","dass"});
    }
    private Message frage3(Message fail){
        return new Message("Egal wie leer Flaschen sind, \nes gibt Flaschen die sind ____.","butter",new Message[]{
                fail,fail,frage4(fail),fail
        },new String[]{"leerer","lehrer","Lehrer", "kaputt"});
    }

    private Message frage4(Message fail){
        return new Message("Meine Oma ist beim FBI.\ndeswegen nennen wir sie jetzt\n___-Sigrid","butter",new Message[]{
                fail,fail,frage5(fail),fail
        },new String[]{"Tob","tohb","Top","Todt"});
    }
    private Message frage5(Message fail){
        return new Message("Der 100-Meter Sprint der siamesischen \nZwillinge war spannend! Es ___ ein\n wahres Kopf-an-Kopf Rennen","butter",new Message[]{
                fail,fail,fail,frage6(fail)
        },new String[]{"ist","wahr","waren","war"});
    }
    private Message frage6(Message fail){
        return new Message("Was haben Altenpfleger und \nArchäologen gemeinsam? Sie beschäftigen \nsich damit alte Knochen zu?reinigen.","butter",new Message[]{
                frage7(fail),fail
        },new String[]{"auseinander","zusammen"});
    }

    private Message frage7(Message fail){
        return new Message("Arbeitnehmer werden begraben, \nBeamte werden umge__.","butter",new Message[]{
                fail,fail,fail,frage8(fail)
        },new String[]{"betet","betett","bettett","bettet"});
    }

    private Message frage8(Message fail){
        return new Message("Was ist 20 Meter lang und stinkt\n nach Urin? Eine ___ im Altenheim.","butter",new Message[]{
                fail,fail,fertig(),fail
        },new String[]{"Bolonese","Bolognese","Polonaise","Polonese"});
    }

    private Message fertig(){
        return new SimpleMessage("Super, gleich nochmal!","butter",null);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
