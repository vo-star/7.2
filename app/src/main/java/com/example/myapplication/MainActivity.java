package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String login_admin = "admin", psw_admin = "pswlogin";
    EditText login, password;
    TextView tv;
    Button log_in;
    String msg;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                Bundle arguments = getIntent().getExtras();
                msg = arguments.get("lgt").toString();
                login.setText(msg);

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        tv = findViewById(R.id.tv);
        log_in = findViewById(R.id.log_in);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().toString().equals(login_admin) && password.getText().toString().equals(psw_admin))
                    tv.setText("Вы вошли в сестему");
                else
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }

        });
    }


}
