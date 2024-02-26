package PaooGame.Audio;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AudioPlayer {
    private List<AudioClip> audioClips;
    public AudioPlayer(){
        audioClips=new ArrayList<>();
    }
    public void update(){
        audioClips.forEach(audioClip -> audioClip.Update());
        List<AudioClip> audioClipscopy=new ArrayList<>();
        audioClipscopy=audioClips;
        audioClipscopy.forEach(audioClip -> {
            if(audioClip.isDone())
            {
                audioClip.closeUP();
                audioClips.remove(audioClip);
            }
        });
    }
    public void playMusic(String filename){
        final Clip clip=getClip(filename);
        audioClips.add(new MusicClip(clip));

    }
    public void playSound(String filename){
        final Clip clip=getClip(filename);
        audioClips.add(new SoundClip(clip));
    }

    private Clip getClip(String filename){
        final URL soundfile=AudioPlayer.class.getResource("/audio/"+filename);
        try(AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(soundfile)) {
            final Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(0);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
        return null;
    }

    public void setAudioClips(List<AudioClip> audioClips) {
        this.audioClips = audioClips;
    }

    public List<AudioClip> getAudioClips() {
        return audioClips;
    }
    public void stopAudioClips() {
        audioClips.removeIf(audioClip -> audioClip!=null);

    }
}
