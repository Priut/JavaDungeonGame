package PaooGame.States;

import PaooGame.Audio.AudioClip;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class DeadState extends State{
    public DeadState(RefLinks refLink) {

        super(refLink);
    }

    @Override
    public void Update() {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        SetState(new MenuState(refLink));
                    }
                },
                2000
        );

    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.drawImage(Assets.meniu,0,0,null);

        g.setFont(new Font("Arial", Font.PLAIN, 32));
        g.drawString("You DIED!", 125, 125);
    }

}
