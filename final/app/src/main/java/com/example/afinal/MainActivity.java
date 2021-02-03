package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_Login1, RelativeLayout_Login2;
    Button Button_news;

    String inputEmail = "";
    String inputPassword = "";
    String emailOK = "1234@naver.com";
    String passwordOK = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_email     = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password  = findViewById(R.id.TextInputEditText_password);
        RelativeLayout_Login1       = findViewById(R.id.RelativeLayout_Login1);
        RelativeLayout_Login2       = findViewById(R.id.RelativeLayout_Login2);
        Button_news                 = findViewById(R.id.Button_news);

        RelativeLayout_Login1.setEnabled(false);
        RelativeLayout_Login2.setEnabled(false);
        Button_news.setEnabled(true);

        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s!=null){
//                    Log.d("SENSI", s.toString());     버그 찾기위해
                    inputEmail = s.toString();
                    RelativeLayout_Login1.setEnabled(validation());
                    RelativeLayout_Login2.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s!=null) {
                    inputPassword = s.toString();
                    RelativeLayout_Login1.setEnabled(validation());
                    RelativeLayout_Login2.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        RelativeLayout_Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                //일반적인 방법 intent
                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);       //클래스 에서 클래스로
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
        RelativeLayout_Login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();
                //일반적인 방법 intent
                Intent intent = new Intent(MainActivity.this, LoginResult2Activity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
            }
        });
        Button_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });


//        RelativeLayout_Login1.setClickable(true);


    }
    public boolean validation(){
        return (inputEmail.equals(emailOK) && inputPassword.equals(passwordOK));
    }
}