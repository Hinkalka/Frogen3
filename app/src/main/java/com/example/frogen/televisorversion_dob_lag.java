package com.example.frogen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class televisorversion_dob_lag extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd, btnRead, btnClear, button11;
    EditText etName, etDescription;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_televisorversion_dob_lag);

        button11 = findViewById(R.id.button11);
        button11.setOnClickListener(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDesc);

        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String desc = etDescription.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        switch (v.getId()) {

            case R.id.button11:
                Intent intent1 = new Intent(this, televisorversion_mane.class);
                startActivity(intent1);

            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_DESC, desc);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;

            case R.id.btnRead:
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
                    Log.d("mLog", "0 rows");

                cursor.close();
                break;

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
        }
        dbHelper.close();
    }
}
