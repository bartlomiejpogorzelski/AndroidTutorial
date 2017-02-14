package com.example.bartek.androidtutorial;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
public static final String KEY= "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle= getIntent().getExtras();
        String text = bundle.getString(KEY, "");
        TextView textView= (TextView) findViewById(R.id.text);



        textView.setText(text);

    }
}
