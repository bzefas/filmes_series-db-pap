package com.zeferino.bruno.pap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zeferino.bruno.pap.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bruno on 15/06/2016.
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn1) Button btn1;
    @BindView(R.id.btn2) Button btn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

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
