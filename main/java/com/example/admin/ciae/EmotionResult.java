package com.example.admin.ciae;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmotionResult extends AppCompatActivity {
    TextView t,t1;
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_result);
        t= (TextView) findViewById(R.id.textView);
        t1= (TextView)findViewById(R.id.textView2);
        Typeface custom_font= Typeface.createFromAsset(getAssets(),"fonts/wilmina.ttf");
        t.setTypeface(custom_font);

        String s=getIntent().getStringExtra("emotion");
        t.setText(getIntent().getStringExtra("emotion"));
        Global.mood=s;


        b4= (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EmotionResult.this,MusicList.class);
                startActivity(i);
                finish();
            }
        });

    }
}
