package PaooGame.Audio;


import javax.sound.sampled.Clip;

public class SoundClip extends AudioClip{
    public SoundClip(Clip clip) {
        super(clip);
    }

    @Override
    protected float getVolume() {
        return 0;
    }
}
