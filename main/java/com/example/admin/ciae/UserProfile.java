package com.example.admin.ciae;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserProfile extends AppCompatActivity {

    TextView t;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        setContentView(R.layout.activity_user_profile);
        t=(TextView) findViewById(R.id.user_profile_name);
        t.setText("Welcome "+ currentFirebaseUser.getEmail());

        b1= (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserProfile.this,EmotionDetect.class);
                startActivity(i);
            }
        });

        b2= (Button) findViewById(R.id.button);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserProfile.this,QuizFirst.class);
                startActivity(i);
            }
        });

        b3= (Button) findViewById(R.id.button2);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(UserProfile.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
