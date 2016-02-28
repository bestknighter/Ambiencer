package com.gbotelhob.ambience;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.gbotelhob.ambience.infrastructureclasses.AudioCue;
import com.gbotelhob.ambience.infrastructureclasses.Scene;

/**
 * Created by gbotelhob on 2/28/2016.
 */
public class DAOHelper extends SQLiteOpenHelper {
    public static int DB_VERSION = 1;
    public static final String DB_NAME = "Ambiencer.db";

    public DAOHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void InsertAudioCue (String AudioCueName, String AudioCueType, String AbsPath) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AudioCues.COLUMN_NAME_AUDIO_NAME, AudioCueName);
        values.put(AudioCues.COLUMN_NAME_AUDIO_TYPE, AudioCueType);
        values.put(AudioCues.COLUMN_NAME_ABSOLUTE_PATH, AbsPath);

        db.insert(AudioCues.TABLE_NAME, null, values);
    }

    public void InsertScene (String SceneName, int Setup_id) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Scenes.COLUMN_NAME_SCENE_NAME, SceneName);
        values.put(Scenes.COLUMN_NAME_SETUP_ID, Setup_id);

        db.insert(Scenes.TABLE_NAME, null, values);
    }

    public void InsertSetup (String SetupName) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Setups.COLUMN_NAME_SETUP_NAME, SetupName);

        db.insert(Setups.TABLE_NAME, null, values);
    }

    public void InsertAudioCueInScene (int AudioCue_id, int Scene_id) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CuesInScene.COLUMN_NAME_AUDIO_CUE_ID, AudioCue_id);
        values.put(CuesInScene.COLUMN_NAME_SCENE_ID, Scene_id);

        db.insert(CuesInScene.TABLE_NAME, null, values);
    }

    public void DestroyAll(){
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL(CuesInScene.SQL_DROP_TABLE);
        db.execSQL(Setups.SQL_DROP_TABLE);
        db.execSQL(Scenes.SQL_DROP_TABLE);
        db.execSQL(AudioCues.SQL_DROP_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AudioCues.SQL_CREATE_TABLE);
        db.execSQL(Scenes.SQL_CREATE_TABLE);
        db.execSQL(Setups.SQL_CREATE_TABLE);
        db.execSQL(CuesInScene.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new SQLiteException("Can't upgrade database from version " +
                oldVersion + " to " + newVersion + ". Please, delete everything and re-do it.");
    }

    public static abstract class AudioCues implements BaseColumns{
        public static final String TABLE_NAME = "audiocues";
        public static final String COLUMN_NAME_AUDIO_CUE_ID = "cue_id";
        public static final String COLUMN_NAME_AUDIO_NAME = "cuename";
        public static final String COLUMN_NAME_AUDIO_TYPE = "cuetype";
        public static final String COLUMN_NAME_ABSOLUTE_PATH = "abspath";

        private static final String SQL_CREATE_TABLE = "CREATE TABLE " + AudioCues.TABLE_NAME + " (" +
                AudioCues.COLUMN_NAME_AUDIO_CUE_ID + " INTEGER PRIMARY KEY, " +
                AudioCues.COLUMN_NAME_AUDIO_NAME + " TEXT NOT NULL, " +
                AudioCues.COLUMN_NAME_AUDIO_TYPE + " TEXT NOT NULL, " +
                AudioCues.COLUMN_NAME_ABSOLUTE_PATH + " TEXT NOT NULL" +
                " )";
        private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + AudioCues.TABLE_NAME;
    }

    public static abstract class Scenes implements BaseColumns{
        public static final String TABLE_NAME = "scenes";
        public static final String COLUMN_NAME_SCENE_ID = "scene_id";
        public static final String COLUMN_NAME_SCENE_NAME = "scenename";
        public static final String COLUMN_NAME_SETUP_ID = "setup_id";

        private static final String SQL_CREATE_TABLE = "CREATE TABLE " + Scenes.TABLE_NAME + " (" +
                Scenes.COLUMN_NAME_SCENE_ID + " INTEGER PRIMARY KEY, " +
                Scenes.COLUMN_NAME_SCENE_NAME + " TEXT NOT NULL, " +
                "FOREIGN KEY ( " + Scenes.COLUMN_NAME_SETUP_ID + " ) " +
                " REFERENCES " + Setups.TABLE_NAME + " ( " + Setups.COLUMN_NAME_SETUP_ID + " ) " +
                " )";
        private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + Scenes.TABLE_NAME;
    }

    public static abstract class Setups implements BaseColumns{
        public static final String TABLE_NAME = "setups";
        public static final String COLUMN_NAME_SETUP_ID = "setup_id";
        public static final String COLUMN_NAME_SETUP_NAME = "setupname";

        private static final String SQL_CREATE_TABLE = "CREATE TABLE " + Setups.TABLE_NAME + " (" +
                Setups.COLUMN_NAME_SETUP_ID + " INTEGER PRIMARY KEY, " +
                Setups.COLUMN_NAME_SETUP_NAME + " TEXT NOT NULL" +
                " )";
        private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + Setups.TABLE_NAME;
    }

    public static abstract class CuesInScene implements BaseColumns{
        public static final String TABLE_NAME = "cuesinscenes";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_SCENE_ID = "scene_id";
        public static final String COLUMN_NAME_AUDIO_CUE_ID = "audiocue_id";

        private static final String SQL_CREATE_TABLE = "CREATE TABLE " + CuesInScene.TABLE_NAME + " (" +
                CuesInScene.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
                CuesInScene.COLUMN_NAME_SCENE_ID + " INTEGER, " +
                CuesInScene.COLUMN_NAME_AUDIO_CUE_ID + " INTEGER, " +
                "FOREIGN KEY( " + CuesInScene.COLUMN_NAME_SCENE_ID + " )" +
                            " REFERENCES " + Scenes.TABLE_NAME + "( " + Scenes.COLUMN_NAME_SCENE_ID + " )" +
                "FOREIGN KEY( " + CuesInScene.COLUMN_NAME_AUDIO_CUE_ID + " )" +
                            " REFERENCES " + AudioCues.TABLE_NAME + "( " + AudioCues.COLUMN_NAME_AUDIO_CUE_ID + " )" +
                " )";
        private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + CuesInScene.TABLE_NAME;
    }
}
