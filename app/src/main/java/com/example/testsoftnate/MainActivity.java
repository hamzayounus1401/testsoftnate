package com.example.testsoftnate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView = findViewById(R.id.text1);
            String sinput =getIntent().getStringExtra("input");
            String spercent = getIntent().getStringExtra("per");


            float input= Float.parseFloat(sinput);
            Float percent = Float.parseFloat(spercent);
            Integer divident = Integer.parseInt(getIntent().getStringExtra("div"));
            String percentNo = getIntent().getStringExtra("radio");
            Toast.makeText(getApplicationContext(),percentNo, Toast.LENGTH_SHORT).show();
            if(percentNo.equals("no")){

                input = input + (input*(percent/100));
                float a= input/divident;
                textView.setText(Float.toString(input)+"\n Per divident:"+  Float.toString(a));
            }
            else{
                input = input+percent;
                float a= input/divident;

                textView.setText(Float.toString(input)+"\n Per divident:"+ Float.toString(a));
            }
        }
}
