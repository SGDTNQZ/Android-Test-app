package com.littlelemon.androidtestapp;

import static com.littlelemon.androidtestapp.StoreDatabase.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

    private StoreDatabase storeDatabase;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        signUp_btn = findViewById(R.id.signUp_btn);

        login_edtxt = findViewById(R.id.login_edtxt);
        password_edtxt = findViewById(R.id.password_edtxt);

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        openSignUpScreen();
        login();

    }


    public void login() {
        View.OnClickListener loginCheck = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = login_edtxt.getText().toString().trim();
                String userPassword = password_edtxt.getText().toString().trim();

                if (TextUtils.isEmpty(userEmail)) {
                    login_edtxt.setError("Please, check your email");
                    return;
                }

                if (TextUtils.isEmpty(userPassword)) {
                    password_edtxt.setError("Please, check your password");
                    return;
                }

                Cursor loginCursor = sqLiteDatabase.rawQuery(
                        "SELECT * FROM " + StoreDatabase.TABLE_NAME +
                                " WHERE " + StoreDatabase.COLUMN_EMAIL + "=? AND " +
                                StoreDatabase.COLUMN_PASSWORD + "=?",
                        new String[]{userEmail, userPassword}
                );

                try {
                    if (loginCursor != null && loginCursor.moveToFirst()) {
                        int nameIndex = loginCursor.getColumnIndexOrThrow(StoreDatabase.COLUMN_NAME);
                        String userName = loginCursor.getString(nameIndex);

                        Intent mainIntent = new Intent(LoginActivity.this, MyCabinet.class);

                        mainIntent.putExtra("email", userEmail);
                        mainIntent.putExtra("name", userName);
                        mainIntent.putExtra("password", userPassword);
                        startActivity(mainIntent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
                    }
                } finally {
                    if (loginCursor != null) {
                        loginCursor.close(); // Close the cursor after use
                    }
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