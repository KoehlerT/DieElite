package com.quickmathstudios.dieelite.game.interactables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.game.StoryEngine;
import com.quickmathstudios.dieelite.game.dialogueEngine.CurrentDialogue;
import com.quickmathstudios.dieelite.game.dialogueEngine.DialogueController;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.ActionMessage;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.Message;
import com.quickmathstudios.dieelite.game.dialogueEngine.dialogue.SimpleMessage;
import com.quickmathstudios.dieelite.utillity.Action;
import com.quickmathstudios.dieelite.utillity.hit.HitBox;
import com.quickmathstudios.dieelite.utillity.hit.Hitable;

public class Bernweich extends Interactable{


    private Message dialog;
    private int trys;

    public Bernweich(Vector2 position) {
        super(new Texture("entities/bernweich.png"),
                position,null);
        this.position = position;
        trys =0;
        constructMessage();
    }



    private Message frage1(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Wie viele Nullen hat ein Gogol?","bernweich",new Message[]{
                new SimpleMessage("Shame! Shame! Shame!", "bernweich",fail),
                new SimpleMessage("OMG, was ist los mit dir?", "bernweich",fail),
                new SimpleMessage("come on...", "bernweich",fail),
                new SimpleMessage("1/1. Als Junge tendierst du zur 3-, aber mal schauen ob du das halten kannst", "bernweich",frage2())
        }, new String[]{"33","18","99","100"});
        return question;
    }

    private Message frage2(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("1. Was ist 3-5*2-(-2-3)*2*2?","bernweich",new Message[]{
                new SimpleMessage("Ganz schwach!", "bernweich",fail),
                new SimpleMessage("Pfffff", "bernweich",fail),
                new SimpleMessage("Nicht schlecht! Weiter gehts!", "bernweich",frage3()),
                new SimpleMessage("Versuchst du es überhaupt?", "bernweich",fail),
        }, new String[]{"-42","42","13","0.5"});
        return question;
    }

    private Message frage3(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Was muss man machen, um gut in Mathe zu werden?","bernweich",new Message[]{
                new SimpleMessage("Ja, bei mir vielleicht", "bernweich",frage4()),
                new SimpleMessage("Aber sowas von!", "bernweich",frage4()),
                new SimpleMessage("Wenn es dir hilft...", "bernweich",frage4()),
                new SimpleMessage("Wenn du das nicht verstehst kannst du eigentlich direkt auf die Hauptschule gehen.", "bernweich",fail),
        }, new String[]{"Sorry, ist angeboren","Rechnen, Rechnen, Rechnen","Mathegym","Ich versteh die Frage nicht"});
        return question;
    }

    private Message frage4(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Wie oft passt die Sonne in die Erde?","bernweich",new Message[]{
                new SimpleMessage("Wer lesen kann ist klar im Vorteil", "bernweich",fail),
                new SimpleMessage("Such Wow", "bernweich",frage5()),
                new SimpleMessage("Das kann ja noch was werden", "bernweich",fail),
                new SimpleMessage("Deine Dummheit widert mich an", "bernweich",fail),
        }, new String[]{"1 299 647 Mal","garnicht","ca. 31 420 Mal","887 212 Mal"});
        return question;
    }

    private Message frage5(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("An welcher Stelle hat f(x) = -x*x+4x-2 einen Extrempunkt?","bernweich",new Message[]{
                new SimpleMessage("Das lernt man doch schon in der Grundschule", "bernweich",fail),
                new SimpleMessage("Sogar mein Kind kann das schon. Und ich habe nichtmal eins.", "bernweich",fail),
                new SimpleMessage("Die Hälfte hast du schon!", "bernweich",frage6()),
                new SimpleMessage("Das ist Mathe und nicht Deutschland : Brazilien!", "bernweich",fail),
        }, new String[]{"(0|2)","(0|0)","(2|2)","(1|7)"});
        return question;
    }

    private Message frage6(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Welche Innenwinkelsumme hat ein Sechseck?","bernweich",new Message[]{
                new SimpleMessage("Wen hattet ihr den letztes Jahr als Lehrer?.. Was mich? Ohh..", "bernweich",fail),
                new SimpleMessage("Du bist so blöde", "bernweich",fail),
                new SimpleMessage("Schneller ging es nicht?", "bernweich",frage7()),
                new SimpleMessage("Schade, dass du kein Mädchen bist, denn dann würde das noch eine 4 werden", "bernweich",fail),
        }, new String[]{"600°","360°","720°","12*pi"});
        return question;
    }

    private Message frage7(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Wie hoch ist die Wahrscheinlichkeit mit 2 Würfeln insgesamt eine 5 zu werfen,\n wenn beide Würfe unter 5 waren?","bernweich",new Message[]{
                new SimpleMessage("Richtig. Genauso hoch wie die Wahrscheinlichkeit, \ndass du dieses Schuljahr bestehst", "bernweich",frage8()),
                new SimpleMessage("ähhhhhm. Nein!", "bernweich",fail),
                new SimpleMessage("Nein. Und wenn du nächstes Mal 1 nimmst, lösch bitte das Spiel.", "bernweich",fail),
                new SimpleMessage("Come on...", "bernweich",fail),
        }, new String[]{"25%","1","100%","5/12"});
        return question;
    }

    private Message frage8(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Was ist die Ableitung von ln(x*pi)?","bernweich",new Message[]{
                new SimpleMessage("pi-st du bescheuert? Hahaha, bin ich witzig!", "bernweich",fail),
                new SimpleMessage("Wieso nachdifferenzieren, wenn du noch nicht mal abgeleitet hast?", "bernweich",fail),
                new SimpleMessage("Falscher als Falsch", "bernweich",fail),
                new SimpleMessage("Bald geschafft!", "bernweich",frage9()),
        }, new String[]{"pi/x","ln(pi*x)*π","1/(pi*x)","1/x"});
        return question;
    }

    private Message frage9(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("Was ist 22*22?","bernweich",new Message[]{
                new SimpleMessage("Du rockst ja das Fünftklass-Grundwissen..", "bernweich",frage10()),
                new SimpleMessage("Also leichter geht es echt nicht.", "bernweich",fail),
                new SimpleMessage("Shame! Shame! Shame!", "bernweich",fail),
                new SimpleMessage("Punkt vor Strich, so ist's richtig, rechne ich!", "bernweich",fail),
        }, new String[]{"484","282","496","22*21+1"});
        return question;
    }

    private Message frage10(){
        Message fail = new SimpleMessage("Du bleibst so lange, bis du alles kannst!","bernweich",null);
        Message question = new Message("In der Klassenarbeit haben 3 von 20 Schülern eine 5. \nWie hoch ist die Wahrscheinlichkeit,\n dass du einer davon bist.","bernweich",new Message[]{
                new SimpleMessage("Frag mal den Mathe-Streber in der Klasse, ob er fürchtet eine 5 zu bekommen,\n vielleicht verstehst du es dann", "bernweich",fail),
                new SimpleMessage("Mit der Felerquote? Auf keinen Fall!", "bernweich",fail),
                new SimpleMessage("Endlich. Danke, Jesus Christus!", "bernweich",
                        new ActionMessage("Ihr seid entlassen", "bernweich", null, new Action() {
                            @Override
                            public void act() {
                                StoryEngine.getInstance().updateStory(1);
                            }
                        })),
                new SimpleMessage("Locker 70 %, bro? Dein ernst?", "bernweich",fail),
        }, new String[]{"15%","0,0%, du hast ja gerade das Mathequiz gerockt!","Nicht im Text enthalten","Locker 70 %, bro!"});
        return question;
    }

    private void constructMessage(){
        dialog = new SimpleMessage("Oh, Ich habe euch heute in meiner Vertretungsstunde","bernweich",
                new SimpleMessage("Hab ich das gerade richtig gehört? Ihr wollt Karten spielen? Nein, das werden\n wir nicht machen. " +
                        "Wir üben etwas Mathematik der vergangenen Jahre. Wenn ihr auf \ndie Idee kommen solltet das Rätsel nicht ernst zu nehmen, " +
                        "dann werde\n ich es eurem Mathelehrer geben und der benotet es dann!","bernweich",4,
                        new SimpleMessage(" Kevin du fängst an!\nIch stelle dir jetzt 10 Fragen und zwar solange, bis du alle richtig hast","bernweich",
                                frage1())));
    }

    @Override
    public void interact() {
        trys++;
        if (trys != 3){
            CurrentDialogue.getInstance().addDialogue(dialog);
        }else{
            CurrentDialogue.getInstance().addDialogue(new ActionMessage("Die Entwickler dieses Spiels lassen Gnade Walten\n" +
                    "Du darfst gehen!", "", 17,null, new Action() {
                @Override
                public void act() {
                    StoryEngine.getInstance().updateStory(1);
                }
            }));
        }

    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
