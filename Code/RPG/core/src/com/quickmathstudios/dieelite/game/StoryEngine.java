package com.quickmathstudios.dieelite.game;

import com.badlogic.gdx.math.Vector2;
import com.quickmathstudios.dieelite.credits.CreditsState;
import com.quickmathstudios.dieelite.cutscene.Cutscene;
import com.quickmathstudios.dieelite.cutscene.CutsceneState;
import com.quickmathstudios.dieelite.cutscene.MovieCutscene;
import com.quickmathstudios.dieelite.game.rooms.*;
import com.quickmathstudios.dieelite.loadingScreen.loadingState;
import com.quickmathstudios.dieelite.main.StateEngine;
import com.quickmathstudios.dieelite.minigames.rowing.RowingState;

public class StoryEngine {
    private static StoryEngine ourInstance = new StoryEngine();

    public static StoryEngine getInstance() {
        return ourInstance;
    }

    private int step = -1;
    private int chapter = 1;
    private int branch = 0; //Branch = 1: Gutes Ergebnis, //Branch = 0: schlechtes Ergebnis

    private StoryEngine() {
        ourInstance = this;
    }
    public void getstoryState() {
        if (chapter == 0){
            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Classroom1());
            }
            if (step == 1) {
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(1100,250),(byte)0b0000_0010));
            }
            if(step == 2) {
                RoomChanger.getInstance().changeRoom(new Secretary());
            }else if (step == 3){
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(100,100), (byte) 0b0000_1000));
            }else if (step == 4){
                //Nach Kreide Holen zurück zu Traber
                System.out.println("Hi Traber");
                RoomChanger.getInstance().changeRoom(new Classroom1());
            }else if (step == 5) {
                //Kreide kommt zurück
                chapter = 1;
                step = -1;
                updateStory();
            }
        }else if (chapter == 1){
            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Classroom2());
                System.out.println("Made Room");
            }if (step == 1){
                //Mit Frau Bernweich geredet
                //Gong??
                System.out.println("HI");
            }if (step == 2){
                //Klick auf Tür
                chapter = 2;
                step = -1;
                updateStory();
            }

        }else if (chapter == 2){
            /**
             * Kevin wird von Der Peiniger Verschleppt und mit Kabelbindern im Gang gefesselt.
             * Herr Leopard findet ihn und sagt, er solle keine Kabelbinder verwenden...
             */
            if (step == 0){
                System.out.println("Chp 3");
                StateEngine.getInstance().SwitchState(new loadingState(
                        new CutsceneState(
                                new Cutscene("chapter3")
                        ),1));
            }
            if (step == 1){
                System.out.println("Next chapter");
                chapter = 3;
                step = -1;
                updateStory();
                //StateEngine.getInstance().SwitchState(new loadingState(new GameState(),1));
            }
        }else if (chapter == 3){
            if (step == 0){
                System.out.println("Story 4");
                StateEngine.getInstance().SwitchState(new loadingState(new CutsceneState(new MovieCutscene("chapter4",1f/24f)),2));

            }
            if (step == 1){
                System.out.println("Ready");
                chapter = 4;
                step = -1;
                StateEngine.getInstance().SwitchState(new GameState());

            }
        }else if (chapter == 4){

            if (step == 0){
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(900,200),(byte)0b0000_0001));
            }

            if (step == 1){
                RoomChanger.getInstance().changeRoom(new Story4());
            }
            if (step == 2){
                chapter = 5;
                step = -1;
                updateStory();
            }

        }else if (chapter == 5){

            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Story6());
            }
            if (step == 1){
                RoomChanger.getInstance().changeRoom(new Story6());
            }
            if (step == 2){
                chapter = 6;
                step = -1;
                updateStory();
            }

        }else if (chapter == 6){
            if (step == 0){
                RoomChanger.getInstance().changeRoom(new Boathouse());
            }

            if (step == 1){
                //Mit herr Büttner geredet
            }

            if (step == 2){
                //Ruderminigame
                System.out.println("Load Minigame");
                StateEngine.getInstance().SwitchState(new loadingState(new RowingState(),1));
            }

            if (step == 3){
                //Zurück vom Rundern
                StateEngine.getInstance().SwitchState(new GameState());
            }
            if (step == 4){
                RoomChanger.getInstance().changeRoom(new Boathouse());
            }if (step == 5){
                //Mit Herr Butter geredet
                chapter = 7;
                step = -1;
                System.out.println("HI");
                updateStory();
            }
        }else if (chapter == 7){
            if (step == 0) {
                StateEngine.getInstance().SwitchState(new loadingState(new CutsceneState(new Cutscene("chapter8")),3));
            }
            if (step == 1){
                //Cutscene beendet
                StateEngine.getInstance().SwitchState(new GameState());
            }
            if (step ==2){
                //Ab in den nächsten Raum
                RoomChanger.getInstance().changeRoom(new CorridorBase(new Vector2(1000,200),(byte)0b0000_0010));
            }
            if (step == 3){
                //Büro Laden
                chapter = 8;
                step = -1;
                updateStory();
            }

        }else if (chapter == 8){
            if (branch == 0){
                if (step == 0){
                    //Herr Butters Büro mit Fragen
                    System.out.println("FRAGEN");
                    RoomChanger.getInstance().changeRoom(new ButterOffice());
                }
            }
            if (branch == 1){
                if (step == 1){
                    //Herr Butters Büro mit Opferritual
                    System.out.println("OFER");
                    StateEngine.getInstance().SwitchState(new loadingState(new CutsceneState(new MovieCutscene("chapter10",1f/10f)),3));
                }

                if (step == 2){
                    chapter = 0;
                    step = -1;
                    branch = 0;
                    StateEngine.getInstance().SwitchState(new loadingState(new CreditsState(),2));
                }
            }
        }



    }
    public void updateStory() {
        System.out.println(chapter+"/"+step);
        step++;
        this.getstoryState();

    }

    public void updateStory(int step){
        System.out.println(chapter+"/"+step);
        this.step = step;
        this.getstoryState();
    }

    public void setBranch(int branch){
        this.branch = branch;
    }

    public int getBranch(){
        return branch;
    }

    public int getChapter() {
        return chapter;
    }

    public int getStep() {
        return step;
    }
}
