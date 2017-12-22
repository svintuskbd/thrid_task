package com.example.oleg.thirdproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText login;
    EditText email;
    EditText phone;
    EditText password;
    EditText passwordConfirm;
    TextView textView;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (EditText) findViewById(R.id.login);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.password_confirm);
        textView = (TextView) findViewById(R.id.text_view);
        send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                if (!isLoginValid(login)) {
                    textView.setText(R.string.login_not_valid);
                } else if (!isEmailValid(email.getText().toString())) {
                    textView.setText(R.string.email_not_valid);
                } else if (!isPhoneValid(phone.getText().toString())) {
                    textView.setText(R.string.phone_not_valid);
                } else if (
                        !isPasswordValid(password.getText().toString(),
                                passwordConfirm.getText().toString())
                        ) {
                    textView.setText(R.string.password_not_valid);
                } else {
                    textView.setText(R.string.validate_confirm);
                }
            }
        });
    }

    protected boolean isLoginValid(EditText loginString) {
        if (loginString.getText().toString().isEmpty()) {
            return false;
        }

        return true;
    }

    protected boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    protected boolean isPhoneValid(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

    protected boolean isPasswordValid(String password, String passwordConfirm) {
        if (password.isEmpty() || passwordConfirm.isEmpty()) {
            return false;
        }

        return password.equals(passwordConfirm);
    }
}
