package com.gbotelhob.ambiencer.infrastructureclasses;

/**
 * Created by gbotelhob on 2/27/2016.
 */
public class AudioCue {

    private String m_AudioName;
    private AudioType m_AudioType;
    private String m_AudioPath;
    private boolean is_playing = false;
    private double m_vol = 50; //Volume 0 - 100
    private double m_cur = 0; //Current Position 0(beginning) - 1(end)

    public AudioCue(String AudioPath){
        m_AudioPath = AudioPath;
        m_AudioName = "NOT SET";
        m_AudioType = AudioType.NOT_SET;
    }

    public AudioCue(String AudioPath, String AudioName, AudioType at){
        m_AudioPath = AudioPath;
        m_AudioName = AudioName;
        m_AudioType = at;
    }

    public String AudioName() {
        return m_AudioName;
    }

    public void AudioName(String AudioName){
        m_AudioName = AudioName;
    }

    public String AudioType(){
        return m_AudioType.ToString();
    }

    public void AudioType(AudioType at){
        m_AudioType = at;
    }

    public void Play(){
        //TODO: Play Audio
        is_playing = true;
    }

    public void Pause(){
        //TODO: Slowly pause
        is_playing = false;
    }

    public void Stop(){
        //TODO: Slowly stop
        is_playing = false;
        m_cur = 0;
    }

    public void Halt(){
        //TODO: Hard Stop
        is_playing = false;
        m_cur = 0;
    }

    public double AudioPosition() {
        return m_cur;
    }

    public double AudioVolume(){
        return m_vol;
    }

    public void ChangeVolume(double change){
        m_vol = Math.max(Math.min(m_vol + change, 100), 0);
    }

    public void AudioVolume(double vol) {
        m_vol = Math.max(Math.min(vol, 100), 0);
    }
}
