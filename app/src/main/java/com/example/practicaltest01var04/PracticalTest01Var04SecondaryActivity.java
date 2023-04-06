package com.example.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    EditText editText1, editText2;

    Button buttonOk, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        editText1 = findViewById(R.id.editTextSecond1);
        editText2 = findViewById(R.id.editTextSecond2);

        buttonOk = findViewById(R.id.buttonOk);
        buttonCancel = findViewById(R.id.buttonCancel);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                editText1.setText("");
                editText2.setText("");
            } else {
                String res = extras.getString("editText1");
                 editText1.setText(res);
                String res2 = extras.getString("editText2");
                editText2.setText(res2);
            }
        }
//21544
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04MainActivity.class);
                intent.putExtra("1", editText1.getText() + "?????");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04MainActivity.class);
                intent.putExtra("1", editText1.getText() + "!!!!!!");
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}