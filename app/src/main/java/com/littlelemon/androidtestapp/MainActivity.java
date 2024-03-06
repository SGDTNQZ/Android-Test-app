package com.littlelemon.androidtestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    TextView tv_q1,tv_q2,tv_q3,tv_q4;
    RadioButton rb_q1_answer1, rb_q1_answer2,
            rb_q2_answer1, rb_q2_answer2,
            rb_q3_answer1, rb_q3_answer2,
            rb_q4_answer1, rb_q4_answer2;

    Button btn_finish;

    String [] questions = {"1 + 1 = ?",
            "2 + 2 = ?",
            "4 + 4 = ? ",
            "10 + 10 = ?"};
    String [][] variants = {{"1","2"},
            {"4","5"},
            {"9","8"},
            {"20","22"}
    };

    String [] answers = {"2","4","8","20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_q1 = findViewById(R.id.tv_q1);
        tv_q2 = findViewById(R.id.tv_q2);
        tv_q3 = findViewById(R.id.tv_q3);
        tv_q4 = findViewById(R.id.tv_q4);

        rb_q1_answer1 = findViewById(R.id.rb_q1_answer1);
        rb_q1_answer2  =findViewById(R.id.rb_q1_answer2);

        rb_q2_answer1 = findViewById(R.id.rb_q2_answer1);
        rb_q2_answer2  =findViewById(R.id.rb_q2_answer2);

        rb_q3_answer1 = findViewById(R.id.rb_q3_answer1);
        rb_q3_answer2  =findViewById(R.id.rb_q3_answer2);

        rb_q4_answer1 = findViewById(R.id.rb_q4_answer1);
        rb_q4_answer2  =findViewById(R.id.rb_q4_answer2);

        btn_finish = findViewById(R.id.btn_finish);

        tv_q1.setText(questions[0]);
        rb_q1_answer1.setText(variants[0][0]);
        rb_q1_answer2.setText(variants[0][1]);

        tv_q2.setText(questions[1]);
        rb_q2_answer1.setText(variants[1][0]);
        rb_q2_answer2.setText(variants[1][1]);

        tv_q3.setText(questions[2]);
        rb_q3_answer1.setText(variants[2][0]);
        rb_q3_answer2.setText(variants[2][1]);

        tv_q4.setText(questions[3]);
        rb_q4_answer1.setText(variants[3][0]);
        rb_q4_answer2.setText(variants[3][1]);

       finish();
    }

    public void check(TextView tv_q, RadioButton rb1, RadioButton rb2, int n){
        if(rb1.isChecked() && rb1.getText().equals(answers[n])){
            tv_q.setText(questions[0] + " Correct");
            tv_q.setTextColor(getResources().getColor(R.color.green));
        } else if (rb2.isChecked() && rb2.getText().equals(answers[n])) {
            tv_q.setText(questions[0] + " Correct");
            tv_q.setTextColor(getResources().getColor(R.color.green));
        } else {
            tv_q.setText(questions[0] + " Wrong");
            tv_q.setTextColor(getResources().getColor(R.color.red));
        }
    }
    public void finish(){
        View.OnClickListener checkTest = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(tv_q1,rb_q1_answer1,rb_q1_answer2,0);
                check(tv_q2,rb_q2_answer1,rb_q2_answer2,1);
                check(tv_q3,rb_q3_answer1,rb_q3_answer2,2);
                check(tv_q4,rb_q4_answer1,rb_q4_answer1,3);
            }
        };

        btn_finish.setOnClickListener(checkTest);
    }
}