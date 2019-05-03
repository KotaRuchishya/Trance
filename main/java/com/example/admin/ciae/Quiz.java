package com.example.admin.ciae;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz extends AppCompatActivity
{
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30;
    Button btn;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    RadioGroup rg;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rg=(RadioGroup) findViewById(R.id.rg);
        r1= (RadioButton) findViewById(R.id.r1);
        r2= (RadioButton) findViewById(R.id.r2);
        r3= (RadioButton) findViewById(R.id.r3);
        r4= (RadioButton) findViewById(R.id.r4);
        r5= (RadioButton) findViewById(R.id.r5);
        r6= (RadioButton) findViewById(R.id.r6);
        r7= (RadioButton) findViewById(R.id.r7);
        r8= (RadioButton) findViewById(R.id.r8);
        r9= (RadioButton) findViewById(R.id.r9);
        r10= (RadioButton) findViewById(R.id.r10);
        r11= (RadioButton) findViewById(R.id.r11);
        r12= (RadioButton) findViewById(R.id.r12);
        r13= (RadioButton) findViewById(R.id.r13);
        r14= (RadioButton) findViewById(R.id.r14);
        r15= (RadioButton) findViewById(R.id.r15);
        r16= (RadioButton) findViewById(R.id.r16);
        r17= (RadioButton) findViewById(R.id.r17);
        r18= (RadioButton) findViewById(R.id.r18);
        r19= (RadioButton) findViewById(R.id.r19);
        r20= (RadioButton) findViewById(R.id.r20);
        r21= (RadioButton) findViewById(R.id.r21);
        r22= (RadioButton) findViewById(R.id.r22);
        r23= (RadioButton) findViewById(R.id.r23);
        r24= (RadioButton) findViewById(R.id.r24);
        r25= (RadioButton) findViewById(R.id.r25);
        r26= (RadioButton) findViewById(R.id.r26);
        r27= (RadioButton) findViewById(R.id.r27);
        r28= (RadioButton) findViewById(R.id.r28);
        r29= (RadioButton) findViewById(R.id.r29);
        r30= (RadioButton) findViewById(R.id.r30);
        t1=(TextView) findViewById(R.id.text_view_question1);
        t2=(TextView) findViewById(R.id.text_view_question2);
        t3=(TextView) findViewById(R.id.text_view_question3);
        t4=(TextView) findViewById(R.id.text_view_question4);
        t5=(TextView) findViewById(R.id.text_view_question5);
        t6=(TextView) findViewById(R.id.text_view_question6);
        t7=(TextView) findViewById(R.id.text_view_question7);
        t8=(TextView) findViewById(R.id.text_view_question8);
        t9=(TextView) findViewById(R.id.text_view_question9);
        t10=(TextView) findViewById(R.id.text_view_question10);
        btn= (Button) findViewById(R.id.button);
        Typeface custom_font=Typeface.createFromAsset(getAssets(),"fonts/amsan1.ttf");
        Typeface custom_font1=Typeface.createFromAsset(getAssets(),"fonts/amsan2.ttf");
        t1.setTypeface(custom_font);
        r1.setTypeface(custom_font1);
        t2.setTypeface(custom_font);
        r2.setTypeface(custom_font1);
        t3.setTypeface(custom_font);
        r3.setTypeface(custom_font1);
        t4.setTypeface(custom_font);
        r4.setTypeface(custom_font1);
        t5.setTypeface(custom_font);
        r5.setTypeface(custom_font1);
        t6.setTypeface(custom_font);
        r6.setTypeface(custom_font1);
        t7.setTypeface(custom_font);
        r7.setTypeface(custom_font1);
        t8.setTypeface(custom_font);
        r8.setTypeface(custom_font1);
        t9.setTypeface(custom_font);
        r9.setTypeface(custom_font1);
        t10.setTypeface(custom_font);

        r10.setTypeface(custom_font1);
        r11.setTypeface(custom_font1);
        r12.setTypeface(custom_font1);
        r13.setTypeface(custom_font1);
        r14.setTypeface(custom_font1);
        r15.setTypeface(custom_font1);
        r16.setTypeface(custom_font1);
        r17.setTypeface(custom_font1);
        r18.setTypeface(custom_font1);
        r19.setTypeface(custom_font1);
        r20.setTypeface(custom_font1);
        r21.setTypeface(custom_font1);
        r22.setTypeface(custom_font1);
        r23.setTypeface(custom_font1);
        r24.setTypeface(custom_font1);
        r25.setTypeface(custom_font1);
        r26.setTypeface(custom_font1);
        r27.setTypeface(custom_font1);
        r28.setTypeface(custom_font1);
        r29.setTypeface(custom_font1);
        r30.setTypeface(custom_font1);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(r1.isChecked())
                {
                    score=score+3;
                }
                if(r2.isChecked())
                {
                    score=score+2;
                }
                if(r3.isChecked())
                {
                    score=score+1;
                }
                if(r4.isChecked())
                {
                    score=score+3;
                }
                if(r5.isChecked())
                {
                    score=score+2;
                }
                if(r6.isChecked())
                {
                    score=score+1;
                }
                if(r7.isChecked())
                {
                    score=score+3;
                }
                if(r8.isChecked())
                {
                    score=score+2;
                }
                if(r9.isChecked())
                {
                    score=score+1;
                }
                if(r10.isChecked())
                {
                    score=score+3;
                }
                if(r11.isChecked())
                {
                    score=score+2;
                }
                if(r12.isChecked())
                {
                    score=score+1;
                }
                if(r13.isChecked())
                {
                    score=score+3;
                }
                if(r14.isChecked())
                {
                    score=score+2;
                }
                if(r15.isChecked())
                {
                    score=score+1;
                }
                if(r16.isChecked())
                {
                    score=score+3;
                }
                if(r17.isChecked())
                {
                    score=score+2;
                }
                if(r18.isChecked())
                {
                    score=score+1;
                }
                if(r19.isChecked())
                {
                    score=score+3;
                }
                if(r20.isChecked())
                {
                    score=score+2;
                }
                if(r21.isChecked())
                {
                    score=score+1;
                }



                if(r22.isChecked())
                {
                    score=score+3;
                }
                if(r23.isChecked())
                {
                    score=score+2;
                }
                if(r24.isChecked())
                {
                    score=score+1;
                }
                if(r25.isChecked())
                {
                    score=score+3;
                }
                if(r26.isChecked())
                {
                    score=score+2;
                }
                if(r27.isChecked())
                {
                    score=score+1;
                }
                if(r28.isChecked())
                {
                    score=score+3;
                }
                if(r29.isChecked())
                {
                    score=score+2;
                }
                if(r30.isChecked())
                {
                    score=score+1;
                }
                Global.message=score;
                Intent intent=new Intent(Quiz.this,Result.class);


                startActivity(intent);
                finish();


            }
        });


    }
}