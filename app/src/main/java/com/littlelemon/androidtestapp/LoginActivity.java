package com.littlelemon.androidtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText login_edtxt, password_edtxt;
    Button login_btn, signUp_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        signUp_btn = findViewById(R.id.signUp_btn);

        login_edtxt = findViewById(R.id.login_edtxt);
        password_edtxt = findViewById(R.id.password_edtxt);

        openSignUpScreen();
        login();

    }

    public void login(){
        View.OnClickListener loginCheck = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(login_edtxt.getText())){
                    login_edtxt.setError("Please, check your email");
                    return;
                }
                if(TextUtils.isEmpty(password_edtxt.getText())){
                    password_edtxt.setError("Please, check your password");
                    return;
                }

                if(login_edtxt.getText().toString().equals("qwerty")
                        && password_edtxt.getText().toString().equals("123"))
                {
                    Intent registrationIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(registrationIntent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Something is wrong!", Toast.LENGTH_LONG).show();
                }

            }
        };

        login_btn.setOnClickListener(loginCheck);
    }

    public void openSignUpScreen(){

        View.OnClickListener openRegistration =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(registrationIntent);
            }
        };
        signUp_btn.setOnClickListener(openRegistration);

    }
}