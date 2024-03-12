package com.littlelemon.androidtestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class PracticeActivity extends AppCompatActivity {

    TextView tv_practice_q1, tv_practice_q2, tv_practice_q3, tv_practice_q4, tv_result;
    RadioButton  rb_practice_q1_variant1, rb_practice_q1_variant2, rb_practice_q1_variant3, rb_practice_q1_variant4,
            rb_practice_q2_variant1, rb_practice_q2_variant2, rb_practice_q2_variant3, rb_practice_q2_variant4,
      rb_practice_q3_variant1, rb_practice_q3_variant2, rb_practice_q3_variant3, rb_practice_q3_variant4,
     rb_practice_q4_variant1, rb_practice_q4_variant2, rb_practice_q4_variant3, rb_practice_q4_variant4;

    Button btn_check;

    String [] practice_questions = {"1+1=?","3+3=?","5+5=?","10+10=?"};
    String [] practice_answers = {"2","6","10","20"};
    String [][] practice_variants = {{"2","3","1","0"},
            {"5","6","3","7"},
            {"9","11","10","12"},
            {"10","12","21","20"}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practice);

        tv_practice_q1 = findViewById(R.id.tv_practice_q1);
        rb_practice_q1_variant1 = findViewById(R.id.rb_practice_q1_variant1);
        rb_practice_q1_variant2 = findViewById(R.id.rb_practice_q1_variant2);
        rb_practice_q1_variant3 = findViewById(R.id.rb_practice_q1_variant3);
        rb_practice_q1_variant4 = findViewById(R.id.rb_practice_q1_variant4);

        tv_practice_q2 = findViewById(R.id.tv_practice_q2);
        rb_practice_q2_variant1 = findViewById(R.id.rb_practice_q2_variant1);
        rb_practice_q2_variant2 = findViewById(R.id.rb_practice_q2_variant2);
        rb_practice_q2_variant3 = findViewById(R.id.rb_practice_q2_variant3);
        rb_practice_q2_variant4 = findViewById(R.id.rb_practice_q2_variant4);

        tv_practice_q3 = findViewById(R.id.tv_practice_q3);
        rb_practice_q3_variant1 = findViewById(R.id.rb_practice_q3_variant1);
        rb_practice_q3_variant2 = findViewById(R.id.rb_practice_q3_variant2);
        rb_practice_q3_variant3 = findViewById(R.id.rb_practice_q3_variant3);
        rb_practice_q3_variant4 = findViewById(R.id.rb_practice_q3_variant4);

        tv_practice_q4 = findViewById(R.id.tv_practice_q4);
        rb_practice_q4_variant1 = findViewById(R.id.rb_practice_q4_variant1);
        rb_practice_q4_variant2 = findViewById(R.id.rb_practice_q4_variant2);
        rb_practice_q4_variant3 = findViewById(R.id.rb_practice_q4_variant3);
        rb_practice_q4_variant4 = findViewById(R.id.rb_practice_q4_variant4);

        tv_result = findViewById(R.id.tv_result);
        btn_check = findViewById(R.id.btn_practice_check);

        tv_practice_q1.setText(practice_questions[0]);
        rb_practice_q1_variant1.setText(practice_variants[0][0]);
        rb_practice_q1_variant2.setText(practice_variants[0][1]);
        rb_practice_q1_variant3.setText(practice_variants[0][2]);
        rb_practice_q1_variant4.setText(practice_variants[0][3]);

        tv_practice_q2.setText(practice_questions[1]);
        rb_practice_q2_variant1.setText(practice_variants[1][0]);
        rb_practice_q2_variant2.setText(practice_variants[1][1]);
        rb_practice_q2_variant3.setText(practice_variants[1][2]);
        rb_practice_q2_variant4.setText(practice_variants[1][3]);

        tv_practice_q3.setText(practice_questions[2]);
        rb_practice_q3_variant1.setText(practice_variants[2][0]);
        rb_practice_q3_variant2.setText(practice_variants[2][1]);
        rb_practice_q3_variant3.setText(practice_variants[2][2]);
        rb_practice_q3_variant4.setText(practice_variants[2][3]);

        tv_practice_q4.setText(practice_questions[3]);
        rb_practice_q4_variant1.setText(practice_variants[3][0]);
        rb_practice_q4_variant2.setText(practice_variants[3][1]);
        rb_practice_q4_variant3.setText(practice_variants[3][2]);
        rb_practice_q4_variant4.setText(practice_variants[3][3]);

        showResult();

    }

    public boolean checkAnswers(RadioButton rb1, RadioButton rb2, RadioButton rb3, RadioButton rb4,int n){
        if(rb1.isChecked() && rb1.getText().equals(practice_answers[n])){
            return true ;
        } else if (rb2.isChecked() && rb2.getText().equals(practice_answers[n])) {
            return true;
        } else if (rb3.isChecked() && rb3.getText().equals(practice_answers[n])) {
            return true;
        } else return rb4.isChecked() && rb4.getText().equals(practice_answers[n]);
    }

    public void  showResult(){
        View.OnClickListener result = v -> {
            float score = 0, percentage;

            if(checkAnswers(rb_practice_q1_variant1, rb_practice_q1_variant2,
                    rb_practice_q1_variant3, rb_practice_q1_variant4,0)){
                score++;
            }
            if (checkAnswers(rb_practice_q2_variant1, rb_practice_q2_variant2,
                    rb_practice_q2_variant3, rb_practice_q2_variant4,1)) {
                score++;
            }
            if (checkAnswers(rb_practice_q3_variant1, rb_practice_q3_variant2,
                    rb_practice_q3_variant3, rb_practice_q3_variant4,2)){
                score++;
            }
            if (checkAnswers(rb_practice_q4_variant1, rb_practice_q4_variant2,
                    rb_practice_q4_variant3, rb_practice_q4_variant4,3)) {
                score++;
            }

            percentage = (100 * score) / 4;
            tv_result.setText(percentage + "%");
        };
        btn_check.setOnClickListener(result);
    }
}