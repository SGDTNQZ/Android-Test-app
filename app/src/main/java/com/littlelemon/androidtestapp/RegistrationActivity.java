package com.littlelemon.androidtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {
   EditText reg_name_edtxt, reg_login_edtxt, reg_password_edtxt;
   Button signUp_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        reg_name_edtxt = findViewById(R.id.reg_name_edtxt);
        reg_login_edtxt = findViewById(R.id.reg_login_edtxt);
        reg_password_edtxt = findViewById(R.id.reg_password_edtxt);

        signUp_btn = findViewById(R.id.signUp_btn);

        register();
    }

    public void register(){
        View.OnClickListener registerUser = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(reg_name_edtxt.getText())){
                    reg_name_edtxt.setError("Please, enter your name");
                    return;
                }
                if(TextUtils.isEmpty(reg_login_edtxt.getText())){
                    reg_login_edtxt.setError("Please, enter your email");
                    return;
                }
                if(TextUtils.isEmpty(reg_password_edtxt.getText())){
                    reg_password_edtxt.setError("Please, enter your password");
                    return;
                }

                Intent goMain = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(goMain);
            }
        };
        signUp_btn.setOnClickListener(registerUser);
    }
}