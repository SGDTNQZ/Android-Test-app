package com.littlelemon.androidtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCabinet extends AppCompatActivity {

    CircleImageView img_user;
    TextView tv_userEmail, tv_userPassword ,
            tv_userName;
    Button btn_startTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_cabinet);

        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("email");
        String userName = intent.getStringExtra("name");
        String userPassword = intent.getStringExtra("password");

        img_user = findViewById(R.id.img_user);

        tv_userEmail = findViewById(R.id.tv_userEmail);
        tv_userEmail.setText("User email: " + userEmail);

//        tv_userPassword = findViewById(R.id.tv_userPassword);
//        tv_userPassword.setText("User password:" + userPassword);

        tv_userName = findViewById(R.id.tv_userName);
        tv_userName.setText("Name: " + userName);

        Glide.with(this)
                .load("https://dwpdigital.blog.gov.uk/wp-content/uploads/sites/197/2016/07/P1090594-1-254x300.jpeg")
                .centerCrop()
                .placeholder(R.drawable.baseline_account_box_24)
                .into(img_user);


        btn_startTest = findViewById(R.id.btn_startTest);
        btn_startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTest = new Intent(MyCabinet.this, MainActivity.class);
                startActivity(openTest);
            }
        });



    }

}