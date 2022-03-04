package com.example.frogen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class televisorversion_mane extends AppCompatActivity implements View.OnClickListener {
    Button button, button2, button3, button4, button5, button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_televisorversion_mane);
        button = button.findViewById(R.id.button);
        button2 = button2.findViewById(R.id.button2);
        button3 = button3.findViewById(R.id.button3);
        button4 = button4.findViewById(R.id.button4);
        button5 = button5.findViewById(R.id.button5);
        button6 = button6.findViewById(R.id.button6);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
            case R.id.button4:
            case R.id.button3:
            case R.id.button2:
                Intent intent = new Intent(this, televisorversion_info.class);
                startActivity(intent);
                break;
            case R.id.button5:
                Intent intent1 = new Intent(this, televisorversion_info.class);
                startActivity(intent1);
            case R.id.button6:
                Intent intent2 = new Intent(this, televisorversion_dob_lag.class);
                startActivity(intent2);
        }
    }
}