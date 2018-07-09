package com.example.tanvir.baiustbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_button;

    int attempt_counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton();
    }

    public void loginButton() {
        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        attempts = (TextView) findViewById(R.id.attempts_textView);
        login_button = (Button) findViewById(R.id.login_button1);
        attempts.setText(Integer.toString(attempt_counter));
        login_button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        if(username.getText().toString().equals("Tanvir") &&
                                password.getText().toString().equals("BaiustCSE"))
                        {
                            Toast.makeText(loginActivity.this, "User and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),AfterLoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(loginActivity.this, "User and password is not correct",
                                    Toast.LENGTH_SHORT).show();

                            attempt_counter--;
                            attempts.setText(Integer.toString(attempt_counter));
                            if(attempt_counter==0){
                                login_button.setEnabled(false);
                            }


                        }
                    }


                }
        );








                }


}