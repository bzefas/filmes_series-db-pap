package com.zeferino.bruno.pap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zeferino.bruno.pap.R;

/**
 * Created by Bruno on 15/06/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainAct();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondAct();
            }
        });


    }

    private void MainAct(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }private void SecondAct(){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
