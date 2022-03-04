package com.example.frogen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class clock_main extends AppCompatActivity implements View.OnClickListener {
    Button button, button2, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_main);

        button6 = button6.findViewById(R.id.button6);

        button6.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button6:
                Intent intent2 = new Intent(this, DobLag.class);
                startActivity(intent2);
        }
    }
}