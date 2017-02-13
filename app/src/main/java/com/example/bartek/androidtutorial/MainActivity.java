package com.example.bartek.androidtutorial;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           }

    public void btnClick(View view) {
        Intent intent = new Intent(view.getContext(), SecondActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit);
        String string = String.valueOf(editText.getText());

        intent.putExtra(SecondActivity.KEY, string);

        startActivity(intent);

    }
}

