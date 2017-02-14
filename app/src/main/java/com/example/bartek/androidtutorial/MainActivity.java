package com.example.bartek.androidtutorial;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
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

    public void btnClick(final View view) {
        AlertDialog.Builder alertD = new AlertDialog.Builder(this);
        alertD.setMessage("Are you sure? ");
        alertD.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                EditText editText = (EditText) findViewById(R.id.edit);
                String string = String.valueOf(editText.getText());

                intent.putExtra(SecondActivity.KEY, string);

                startActivity(intent);

            }
        });
        alertD.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertD.show();
    }
}

