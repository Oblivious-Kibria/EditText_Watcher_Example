package com.example.adorableaayan.edittextwatcherexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextWatcher;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWatcher = (EditText) findViewById(R.id.editTextWatcher);
        textView = (TextView) findViewById(R.id.textView);

        editTextWatcher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, "before_Changed", Toast.LENGTH_SHORT).show();
                textView.setText(""+0);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, "on_Changed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(MainActivity.this, "after_Changed", Toast.LENGTH_SHORT).show();
               try{
                   int Price = Integer.parseInt(editable.toString());
                   int sum = Price + 10;
                   textView.setText(""+sum);
               }catch (Exception e){

               }
            }
        });
    }

}
