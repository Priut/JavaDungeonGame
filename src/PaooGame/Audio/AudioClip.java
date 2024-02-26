package PaooGame.Audio;


import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public abstract class AudioClip {
    private final Clip clip;

    public AudioClip(Clip clip) {
        this.clip = clip;
        clip.start();
    }

    public void Update()
    {
        setVolume();
    }

    public void setVolume() {
        final FloatControl control=(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        control.setValue((float) 0.1);
    }

    protected abstract float getVolume();

    public boolean isDone(){
        return !clip.isRunning();
    }
    public void closeUP(){
        clip.close();
    }

}
