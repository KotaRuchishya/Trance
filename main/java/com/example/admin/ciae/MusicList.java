package com.example.admin.ciae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MusicList extends AppCompatActivity {

    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);
        l= (ListView) findViewById(R.id.listview);
        if(Global.mood.equals("Happy"))
        {
            final String values[] = l.getResources().getStringArray(R.array.happy);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                    Global.song=values[position];
                    Intent Intent = new Intent(MusicList.this, Player.class);
                    /*Intent.putExtra("song",values[position]);*/
                    startActivity(Intent);
                }
            });
        }
        else if(Global.mood.equals("Sad"))
        {
            final String values[] = l.getResources().getStringArray(R.array.sad);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                    Global.song=values[position];
                    Intent Intent = new Intent(MusicList.this, Player.class);
                    /*Intent.putExtra("song",values[position]);*/
                    startActivity(Intent);
                }
            });
        }
        else if(Global.mood.equals("Angry"))
        {
            final String values[] = l.getResources().getStringArray(R.array.angry);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
            l.setAdapter(adapter);
            l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {

                    Global.song=values[position];
                    Intent Intent = new Intent(MusicList.this, Player.class);
                    /*Intent.putExtra("song",values[position]);*/
                    startActivity(Intent);
                }
            });
        }



    }
}


