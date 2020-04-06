package com.example.testsoftnate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity {
    EditText ac;
    CardView cardView;
    TextView  per, div;
    Button cal;
    RadioGroup radioGroup;
    RadioButton r1, r2;
    CircleImageView a1,a2,m1,m2;
    float percent = 0;
    int dividend =1;
    boolean custom = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ac = findViewById(R.id.input_account);
        per = findViewById(R.id.one_edit);
        div = findViewById(R.id.two_edit);
        cardView = findViewById(R.id.cardView);
        a1= findViewById(R.id.add_one);
        a2= findViewById(R.id.add_two);
        m1= findViewById(R.id.minus_one);
        m2= findViewById(R.id.minus_two);
        radioGroup = findViewById(R.id.radio_group);
        r1 = findViewById(R.id.ri1);
        r2 = findViewById(R.id.ri2);
        radioGroup.setOnCheckedChangeListener(MYOnCheckChangeListener);
        per.setText("0.0");
        div.setText("1");
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_splash_screen_transition);
        cardView.setAnimation(animation);

        a1.setOnClickListener(MyOnClickListiner);
        a2.setOnClickListener(MyOnClickListiner);
        m1.setOnClickListener(MyOnClickListiner);
        m2.setOnClickListener(MyOnClickListiner);
        cal=  findViewById(R.id.cal);
        ac.addTextChangedListener(MyTextWatcher);
        cal.setOnClickListener(MyOnClickListiner);

    }

    View.OnClickListener MyOnClickListiner
            = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.add_one:
                    percent+=1;
                    per.setText(Float.toString(percent));
                break;
                case R.id.add_two:
                    dividend +=1;
                    div.setText(Integer.toString(dividend));
                break;
                case R.id.minus_one:
                    percent-=1;
                    per.setText(Float.toString(percent));
                    break;
                case R.id.minus_two:
                    if(dividend>=2){
                    dividend-=1;
                        div.setText(Integer.toString(dividend));}
                    break;
                case R.id.cal:

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("input", ac.getText().toString());
                    intent.putExtra("per",Float.toString(percent));
                    intent.putExtra("div", Integer.toString(dividend));
                    if(custom==false){
                    intent.putExtra("radio", "no");


                    }
                    else {
                        intent.putExtra("radio", "yes");



                    }
                        startActivity(intent);
                    break;
                default:
            }
        }
    };


    TextWatcher MyTextWatcher
            = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
                if (ac!=null){
                    if (ac.length()>0){
                        cal.setEnabled(true);
                    }
                    else cal.setEnabled(false);

                }
        }
    };
    RadioGroup.OnCheckedChangeListener MYOnCheckChangeListener
            = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if(checkedId == R.id.ri2){
                custom=true;
            }
            if(checkedId == R.id.ri1){
                custom=false;


            }
        }
    };

}
