package com.gbotelhob.ambience.infrastructureclasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gbotelhob on 2/27/2016.
 */
public class Setup {
    private ArrayList<Scene> m_Scenes;
    private String m_SetupName;

    public Setup(){
        m_SetupName = "NOT_SET";
        m_Scenes = new ArrayList<Scene>();
    }

    public Setup(String SetupName){
        m_SetupName = SetupName;
        m_Scenes = new ArrayList<Scene>();
    }

    public Setup(String SetupName, ArrayList<Scene> scenes){
        m_SetupName = SetupName;
        m_Scenes = (ArrayList<Scene>)scenes.clone();
    }

    public Setup(String SetupName, Scene... scenes){
        m_SetupName = SetupName;
        Collections.addAll(m_Scenes, scenes);
    }

    public String SetupName(){
        return m_SetupName;
    }

    public void SetupName(String SetupName){
        m_SetupName = SetupName;
    }

    public ArrayList<Scene> Scenes(){
        return m_Scenes;
    }

    public boolean AddScene(Scene s){
        return m_Scenes.add(s);
    }

    public void ClearScenes(){
        m_Scenes.clear();
    }

    public void DelScene(int index){
        m_Scenes.remove(index);
    }

    public boolean DelScene(Scene s){
        return m_Scenes.remove(s);
    }
}
