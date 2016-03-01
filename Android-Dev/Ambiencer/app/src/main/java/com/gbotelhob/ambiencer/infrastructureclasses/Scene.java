package com.gbotelhob.ambiencer.infrastructureclasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gbotelhob on 2/27/2016.
 */
public class Scene {
    private String m_SceneName;
    private ArrayList<AudioCue> m_audios;

    public Scene(String sceneName){
        m_SceneName = sceneName;
        m_audios = new ArrayList<>();
    }

    public Scene(String sceneName, ArrayList<AudioCue> audios){
        m_SceneName = sceneName;
        m_audios = (ArrayList<AudioCue>)audios.clone();
    }

    public Scene(String sceneName, AudioCue... audios){
        m_SceneName = sceneName;
        Collections.addAll(m_audios, audios);
    }

    public String SceneName(){
        return m_SceneName;
    }

    public ArrayList<AudioCue> AudioCues(){
        return m_audios;
    }

    public boolean AddAudio(AudioCue ac){
        return m_audios.add(ac);
    }

    public void ClearAudios(){
        m_audios.clear();
    }

    public void DelAudio(int index){
        m_audios.remove(index);
    }

    public boolean DelAudio(AudioCue ac){
        return m_audios.remove(ac);
    }

}
