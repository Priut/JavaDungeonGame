package PaooGame.States;

import PaooGame.Audio.AudioClip;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    private String[] optionsMenu;
    private static final String START_GAME = "Start Game";
    private static final String QUIT_GAME = "Quit game";
    private static final String ABOUT = "About";
    private static final String SETTINGS = "Settings";
    private static final String HIGHSCORES = "HighScores";
    private int selected;

    public MenuState(RefLinks refLinks) {
        super(refLinks);
        this.optionsMenu = new String[] {START_GAME, ABOUT,SETTINGS,HIGHSCORES,QUIT_GAME};//optiunile meniului
        this.selected = 100;//variabila pentru selectie,initial nu selectam nimic
    }

    @Override
    public void Update() {
        if(refLink.GetMouseManager().getMouseX()>110&&refLink.GetMouseManager().getMouseX()<300&&
                refLink.GetMouseManager().getMouseY()>5&&refLink.GetMouseManager().getMouseY()<55)
        {
            selected=0;
           // refLink.GetGame().getAudioPlayer().playSound("coin_collect.wav");
            if(refLink.GetMouseManager().isLeftPressed()) {
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    SetState(new PlayState(refLink,1));
                                    refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                                }
                            },
                            100
                    );
            }
        }

        if(refLink.GetMouseManager().getMouseX()>110&&refLink.GetMouseManager().getMouseX()<300&&
                refLink.GetMouseManager().getMouseY()>55&&refLink.GetMouseManager().getMouseY()<105)
        {
            selected=1;
            if(refLink.GetMouseManager().isLeftPressed()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                SetState(new AboutState(refLink));
                                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                            }
                        },
                        100
                );
            }
        }
        if(refLink.GetMouseManager().getMouseX()>110&&refLink.GetMouseManager().getMouseX()<300&&
                refLink.GetMouseManager().getMouseY()>105&&refLink.GetMouseManager().getMouseY()<155)
        {
            selected=2;
            if(refLink.GetMouseManager().isLeftPressed()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                SetState(new SettingsState(refLink));
                                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                            }
                        },
                        100
                );
            }
        }
        if(refLink.GetMouseManager().getMouseX()>110&&refLink.GetMouseManager().getMouseX()<300&&
                refLink.GetMouseManager().getMouseY()>155&&refLink.GetMouseManager().getMouseY()<205)
        {
            selected=3;
            if(refLink.GetMouseManager().isLeftPressed()) {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                SetState(new HighScores(refLink));
                                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
                            }
                        },
                        100
                );
            }
        }
        if(refLink.GetMouseManager().getMouseX()>110&&refLink.GetMouseManager().getMouseX()<300&&
                refLink.GetMouseManager().getMouseY()>205&&refLink.GetMouseManager().getMouseY()<255)
        {
            selected=4;
            if(refLink.GetMouseManager().isLeftPressed()) {
                System.exit(0);
                refLink.GetGame().getWindow().GetWndFrame().requestFocusInWindow();
            }
        }
    }
    //desenam meniul
    //daca am selectat o optiune setam o alta culoare pentru a iesi in evidenta

    @Override
    public void Draw(Graphics graphics) {
        graphics.drawImage(Assets.meniu,0,0,null);

        graphics.setFont(new Font("Arial", Font.PLAIN, 32));
        for(int i=0;i<this.optionsMenu.length;i++) {
            if(i==this.selected) graphics.setColor(Color.WHITE);
            else graphics.setColor(Color.LIGHT_GRAY);
            graphics.drawString(this.optionsMenu[i], 125, 42 + i * 49);
        }
    }


}
