package com.example.frogen;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class televisorversion_info extends AppCompatActivity implements View.OnClickListener{
        Button button7, button8, button9, button10;
        DBHelper dbHelper;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_televisorversion_info);

            button7 = (Button) findViewById(R.id.button7);
            button7.setOnClickListener(this);
            button8 = findViewById(R.id.button8);
            button8.setOnClickListener(this);
            button9 = (Button) findViewById(R.id.button9);
            button9.setOnClickListener(this);
            button10 = (Button) findViewById(R.id.button10);
            button10.setOnClickListener(this);
            dbHelper = new DBHelper(this);

        }
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.button9:
                    Intent intent1 = new Intent(this,televisorversion_mane.class);
                    startActivity(intent1);
                case R.id.button10:
                    Intent intent2 = new Intent(this,televisorversion_dob_lag.class);
                    startActivity(intent2);
                case R.id.button7:
                    Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                    if (cursor.moveToFirst()) {
                        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                        int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                        int descIndex = cursor.getColumnIndex(DBHelper.KEY_DESC);
                        do {
                            Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                                    ", Название лягушки = " + cursor.getString(nameIndex) +
                                    ", Описание = " + cursor.getString(descIndex));
                        } while (cursor.moveToNext());
                    } else
                        Log.d("mLog","0 rows");

                    cursor.close();
                    break;
                case R.id.button8:
                    Cursor cursor1 = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                    if (cursor1.moveToFirst()) {
                        int idIndex = cursor1.getColumnIndex(DBHelper.KEY_ID);
                        int nameIndex = cursor1.getColumnIndex(DBHelper.KEY_NAME);
                        do {
                            Log.d("mLog", "ID = " + cursor1.getInt(idIndex) +
                                    ", Название лягушки = " + cursor1.getString(nameIndex));
                        } while (cursor1.moveToNext());
                    } else
                        Log.d("mLog","0 rows");

                    cursor1.close();
                    break;

            }
            dbHelper.close();
        }

    }