package com.gbotelhob.ambiencer.infrastructureclasses;

/**
 * Created by gbotelhob on 2/27/2016.
 */
public enum AudioType {
    NOT_SET,
    SFX,
    AMBIENCE,
    BGM;

    public String ToString(){
        switch (this){
            case NOT_SET:
                return "NOT_SET";
            case SFX:
                return "SFX";
            case AMBIENCE:
                return "Ambience";
            case BGM:
                return "BGM";
            default:
                return "INEXISTENT";
        }
    }
}
