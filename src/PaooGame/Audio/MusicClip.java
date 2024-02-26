package PaooGame.Audio;


import javax.sound.sampled.Clip;

public class MusicClip extends AudioClip{
    public MusicClip(Clip clip) {
        super(clip);
    }

    @Override
    protected float getVolume() {
        return 0;
    }
}
