package com.example.bartek.androidtutorial;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
    private int i=0;
    int count=0;
    public final static String PREF= "my prefs";
    public final static String KEY_PREF= " shared";
    TextView sText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sText= (TextView) findViewById(R.id.sharedID);
        SharedPreferences shP= getSharedPreferences(PREF,0);
        count= shP.getInt(KEY_PREF, 0);
        updateText(sText);
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

    public void nClick(View view) {
        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent= new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,0,intent,0 );

        Notification.Builder notificationBuilder= new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_menu_zoom)
                .setContentTitle("NOTYFIKACJA")
                .setContentText("This is content ...")
                .setContentInfo("Masz:"+ ++i + "wiadomości")
                //.setNumber(++i) // w prawym rogu liczba klikniec się pojawia przy notyfikacji
                .setAutoCancel(true) // czy chcemy aby sama sie usuwała po kliknieciu
                .setContentIntent(pendingIntent);


        Notification notification = notificationBuilder.build();

        notificationManager.notify(0, notification);

    }


    public void sherClick(View view) {
        count++;

        updateText(sText);
    }
    private void updateText(TextView sText) {
        sText.setText(String.valueOf(count));
    }

    @Override
    protected void onDestroy() {    //onDestroy pojawia sie w momencie zamknieta aktywnosci
        super.onDestroy();
        SharedPreferences shP = getSharedPreferences(PREF,0);
        shP.edit().putInt(KEY_PREF, count).apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (id == R.id.action)
        {
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

