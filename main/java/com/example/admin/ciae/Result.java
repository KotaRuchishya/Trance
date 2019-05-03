package com.example.admin.ciae;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView t2,t1;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        t2= (TextView) findViewById(R.id.textView8);
        t1= (TextView) findViewById(R.id.textView5);

        Typeface custom_font=Typeface.createFromAsset(getAssets(),"fonts/wilmina.ttf");
        t1.setTypeface(custom_font);
        b=(Button)findViewById(R.id.button2);
        int result=Global.message;
        String score=String.valueOf(result);
        if((result>=10)&&(result<15))
        {
            t2.setText("Happy");
            t2.setTypeface(custom_font);
        }
        if((result>=15)&&(result<22))
        {
            t2.setText("Sad");
            t2.setTypeface(custom_font);
        }
        if(result>=22)
        {
            t2.setText("Angry");
            t2.setTypeface(custom_font);
        }

        String res= (String) t2.getText();
        Global.mood=res;
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent=new Intent(Result.this,MusicList.class);
                startActivity(intent);
                finish();

            }
        });



    }
}

