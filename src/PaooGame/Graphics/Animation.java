package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed, index;
    private long time, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed=speed;
        this.frames=frames;
        index=0;
        timer=0;
        time=System.currentTimeMillis();
    }

    public void update(){
        timer+=System.currentTimeMillis()-time;
        time=System.currentTimeMillis();

        if(timer>speed)
        {
            index++;
            timer=0;
            if(index>= frames.length)
                index=0;
        }
    }

    public BufferedImage getCurrentFrame(){return frames[index];}
}
