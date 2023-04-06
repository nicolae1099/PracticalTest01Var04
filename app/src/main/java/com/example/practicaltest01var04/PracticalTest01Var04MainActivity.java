package com.example.practicaltest01var04;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {


    TextView textView;

    Button buttonDisplayInfo, navigate_to_secondary_activity_button;

    EditText editText1, editText2;

    CheckBox checkBox1, checkBox2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);


        buttonDisplayInfo = findViewById(R.id.buttonDisplayInfo);
        navigate_to_secondary_activity_button = findViewById(R.id.buttonNavigate);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        editText1.setText("");
        editText2.setText("");
        textView.setText("");

        buttonDisplayInfo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    if (!editText1.getText().equals("")) {
                        textView.setText(textView.getText().toString() + editText1.getText().toString());
                    }
                } else {
                    Toast.makeText(PracticalTest01Var04MainActivity.this, "Not checked", Toast.LENGTH_LONG).show();
                }

                if (checkBox2.isChecked()) {
                    if (!editText2.getText().equals("")) {
                        textView.setText(textView.getText().toString() + editText2.getText().toString());
                    }
                } else {
//                    Toast.makeText(this, "2nd tick", Toast.LENGTH_SHORT);
                    Toast.makeText(PracticalTest01Var04MainActivity.this, "wow", Toast.LENGTH_SHORT).show();
                }
            }
        });


        navigate_to_secondary_activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                intent.putExtra("editText1", editText1.getText().toString());
                intent.putExtra("editText2", editText2.getText().toString());
                startActivityForResult(intent, 1);
            }
        });

    }


    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("editText1", editText1.getText().toString());
        outState.putString("editText2", editText2.getText().toString());
        outState.putString("textView", textView.getText().toString());


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("editText1")) {
            String aux = savedInstanceState.getString("editText1");
            editText1.setText(aux);
        }

        if (savedInstanceState.containsKey("editText2")) {
            String aux = savedInstanceState.getString("editText2");
            editText2.setText(aux);
        }

        if (savedInstanceState.containsKey("textView")) {
            String aux = savedInstanceState.getString("textView");
            textView.setText(aux);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Super ok", Toast.LENGTH_SHORT).show();
            }
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Super not ok", Toast.LENGTH_SHORT).show();
            }
        }
    }
}