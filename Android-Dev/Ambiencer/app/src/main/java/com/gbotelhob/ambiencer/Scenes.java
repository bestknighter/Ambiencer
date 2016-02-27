package com.gbotelhob.ambiencer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Scenes extends AppCompatActivity {

    String[] fakeScenes = {"All", "Intro", "Forest", "Dungeon", "Castle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_scene, fakeScenes);
        ListView lv = (ListView)findViewById(R.id.listview_scenes);
        lv.setAdapter(adapter);

    }
}
